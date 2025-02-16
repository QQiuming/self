package com.example.self.reg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.self.reg.entity.Taxpayer;
import com.example.self.reg.entity.TaxpayerBusDetail;
import com.example.self.reg.entity.TaxpayerDetail;
import com.example.self.reg.entity.TaxpayerIndDetail;
import com.example.self.reg.mapper.TaxpayerMapper;
import com.example.self.reg.service.TaxpayerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.self.reg.service.TaxpayerStrategyService;
import com.example.self.reg.service.TaxpayerStrategyServiceFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 服务实现类
 *
 * @author qiuming
 * @since 2025-01-19
 */
@Service
public class TaxpayerServiceImpl extends ServiceImpl<TaxpayerMapper, Taxpayer> implements TaxpayerService {

    @Autowired
    TaxpayerMapper taxpayerMapper;

    @Autowired
    TaxpayerStrategyServiceFactory taxpayerStrategyServiceFactory;

    @Override
    public Taxpayer getTaxpayer(Integer id) {

        return taxpayerMapper.selectById(id);
    }

    @Override
    public List<Taxpayer> getAllTaxpayer() {
        return taxpayerMapper.selectList(null);

    }

    @Override
    public void add(Taxpayer taxpayer) {
        taxpayerMapper.insert(taxpayer);
    }

    @Override
    public int modify(Taxpayer taxpayer) {
        //乐观锁更新
        Taxpayer currentTaxpayer = taxpayerMapper.selectById(taxpayer.getId());
        taxpayer.setLockVersion(currentTaxpayer.getLockVersion());
        return taxpayerMapper.updateById(taxpayer);
    }

    @Override
    public void remove(String ids) {

        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                taxpayerMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

    @Override
    public TaxpayerIndDetail queryTaxpayerIndInfoByBizId(String bizId) {
        return taxpayerMapper.queryTaxpayerIndInfoByBizId(bizId);
    }

    @Override
    public TaxpayerBusDetail queryTaxpayerBusInfoByBizId(String taxpayerId) {
        return taxpayerMapper.queryTaxpayerBusInfoByBizId(taxpayerId);
    }

    @Override
    public TaxpayerDetail queryTaxpayerInfoByBizId(String taxpayerId) {
        return getTaxpayerStrategyService(taxpayerId).queryTaxpayerDetail(taxpayerId);
    }

    @Override
    public Taxpayer queryTaxpayerByBizId(String taxpayerId) {
        return taxpayerMapper.selectOne(new LambdaQueryWrapper<Taxpayer>().eq(Taxpayer::getBizId, taxpayerId));
    }


    private String queryTaxpayerType(String taxpayerId) {
        return queryTaxpayerByBizId(taxpayerId).getTaxpayerType();
    }


    private TaxpayerStrategyService getTaxpayerStrategyService(String taxpayerId) {
        return taxpayerStrategyServiceFactory.get(queryTaxpayerType(taxpayerId));
    }

}


