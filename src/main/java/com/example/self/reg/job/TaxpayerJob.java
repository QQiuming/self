package com.example.self.reg.job;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.self.reg.entity.Taxpayer;
import com.example.self.reg.service.TaxpayerService;
import com.example.self.sys.entity.Organization;
import com.example.self.sys.service.OrganizationService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * @descriptions: TaxpayerJob
 * @author: qiuming
 * @date: 2025/1/23 15:58
 * @version: 1.0
 */
@Component
@Slf4j
public class TaxpayerJob {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    TaxpayerService taxpayerService;

    private static final int CAPACITY = 2000;

    private final BlockingQueue<Taxpayer> taxpayerBlockingQueue = new LinkedBlockingQueue<>(CAPACITY);

    private final ForkJoinPool forkJoinPool = new ForkJoinPool(10);

    private static final Taxpayer POISON = new Taxpayer();

    private static final int PAGE_SIZE = 2;

    @XxlJob("demoTaxpayerJob")
    public void demoTaxpayerJob(){
        log.info("this is demoTaxpayerJob execute...");
        List<Long> orgList = organizationService.list().stream().map(Organization::getId).collect(Collectors.toList());
        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();
        log.info("shardTotal:{} =====> shardIndex: {}",shardTotal,shardIndex);
        List<Long> pengdingOrgIdList = orgList.stream().filter(item -> item % shardTotal == shardIndex).collect(Collectors.toList());
        Integer currentPage = 1;
        for (Long orgId : pengdingOrgIdList) {
            try {
                Page<Taxpayer> page = taxpayerService.page(new Page<>(currentPage, PAGE_SIZE),new LambdaQueryWrapper<Taxpayer>().eq(Taxpayer::getOrgId, String.valueOf(orgId)));
                taxpayerBlockingQueue.addAll(page.getRecords());

                forkJoinPool.execute(this::executeTaxpayer);

                while (page.hasNext()){
                    currentPage++;
                    page = taxpayerService.page(new Page<>(currentPage, PAGE_SIZE),new LambdaQueryWrapper<Taxpayer>().eq(Taxpayer::getOrgId, String.valueOf(orgId)));
                    taxpayerBlockingQueue.addAll(page.getRecords());
                }
            }finally {
                taxpayerBlockingQueue.add(POISON);
            }

        }

    }


    private void executeTaxpayer() {
        Taxpayer taxpayer = null;
        try {
            while (true) {
                taxpayer = taxpayerBlockingQueue.take();
                if (taxpayer == POISON) {
                    log.debug("POISON toked from blocking queue");
                    break;
                }
                log.info("executeTimeout tradeOrderId = {}" , taxpayer.getBizId());
                executeTaxpayer(taxpayer);
            }
        } catch (InterruptedException e) {
            log.error("executeTimeout failed", e);
        }
        log.debug("executeTimeout finish");
    }

    private void executeTaxpayer(Taxpayer taxpayer) {
        log.info("executeTaxpayer taxpayerId = {}", taxpayer.getBizId());
    }
}
