package com.example.self.reg.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.self.base.common.constant.BusinessCode;
import com.example.self.base.sharding.id.DistributeID;
import com.example.self.base.sharding.id.WorkerIdHolder;
import com.example.self.reg.entity.Taxpayer;
import com.example.self.reg.entity.TaxpayerIndDetail;
import com.example.self.reg.service.TaxpayerService;
import com.example.self.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @descriptions: TaxpayerController
 * @author: qiuming
 * @date: 2025/1/19 17:35
 * @version: 1.0
 */
@RestController
@RequestMapping("/reg")
public class TaxpayerController {

    @Autowired
    private TaxpayerService taxpayerService;

    @PostMapping("/saveTaxpayer")
    public String savaTaxpayer(@RequestBody Taxpayer taxpayer){
        User user = (User)StpUtil.getSession().get("user");
        taxpayer.setOrgId(user.getOrgId());
        taxpayer.setBizId(DistributeID.generateWithSnowflake(BusinessCode.TAXPAYER_SHARDING, WorkerIdHolder.WORKER_ID,user.getOrgId()));
        taxpayerService.add(taxpayer);
        return "success";
    }


    @GetMapping("/queryTaxpayer")
    public String queryTaxpayer(@RequestParam String taxpayerId){
        Taxpayer taxpayer = taxpayerService.getOne(new QueryWrapper<Taxpayer>().eq("biz_id",taxpayerId));
        return "success";
    }



    @GetMapping("/queryTaxpayerByOrgId")
    public Map queryTaxpayerByOrgId(){
        Map<String,List<Taxpayer>> map = new HashMap<>();
        User user = (User)StpUtil.getSession().get("user");
        String ordId = user.getOrgId();
        List<Taxpayer> taxpayerList = taxpayerService.list(new QueryWrapper<Taxpayer>().eq("org_id",ordId));
        map.put("orgUser",taxpayerList);
        map.put("allUser",taxpayerService.getAllTaxpayer());
        return map;
    }

    @GetMapping("/queryTaxpayerPage")
    public Page<Taxpayer> queryTaxpayerPage(Integer pageNum,Integer pageSize){
        Page<Taxpayer> page = new Page<>(pageNum,pageSize);
        return taxpayerService.page(page,new LambdaQueryWrapper<Taxpayer>().orderByAsc(Taxpayer::getCreateTime));
    }

}
