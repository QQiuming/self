package com.example.self.reg.service;

import cn.hutool.json.JSONUtil;
import com.example.self.reg.entity.TaxpayerBusDetail;
import com.example.self.reg.entity.TaxpayerDetail;
import com.example.self.reg.entity.TaxpayerIndDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TaxpayerServiceTest {

    @Autowired
    TaxpayerService taxpayerService;

    @Test
    void queryTaxpayerIndInfoByBizId() {
        TaxpayerIndDetail taxpayerIndDetail = taxpayerService.queryTaxpayerIndInfoByBizId("1018809599867471503360000");
        System.out.println(JSONUtil.toJsonStr(taxpayerIndDetail));
    }

    @Test
    void queryTaxpayerBusInfoByBizId() {
        TaxpayerBusDetail taxpayerBusDetail = taxpayerService.queryTaxpayerBusInfoByBizId("1018815885214425907200003");
        System.out.println(JSONUtil.toJsonStr(taxpayerBusDetail));

    }

    @Test
    void queryTaxpayerInfoByBizId() {
//        String taxpayerId = "1018815885214425907200003";
        String taxpayerId = "1018809599867471503360000";
        TaxpayerDetail taxpayerDetail = taxpayerService.queryTaxpayerInfoByBizId(taxpayerId);
        System.out.println(JSONUtil.toJsonStr(taxpayerDetail));


    }



}