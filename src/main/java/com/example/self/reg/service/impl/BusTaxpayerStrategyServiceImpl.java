package com.example.self.reg.service.impl;

import com.example.self.reg.entity.TaxpayerBusDetail;
import com.example.self.reg.entity.TaxpayerDetail;
import com.example.self.reg.service.TaxpayerBusService;
import com.example.self.reg.service.TaxpayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @descriptions: TaxpayerStrategyIndServiceImpl
 * @author: qiuming
 * @date: 2025/1/21 15:58
 * @version: 1.0
 */

@Service("busTaxpayerStrategyService")
public class BusTaxpayerStrategyServiceImpl extends TaxpayerStrategyServiceImpl{

    @Autowired
    private TaxpayerService taxpayerService;


    @Override
    public TaxpayerDetail queryTaxpayerDetail(String taxpayerId) {
        TaxpayerBusDetail taxpayerBusDetail = taxpayerService.queryTaxpayerBusInfoByBizId(taxpayerId);
        return combineTaxpayerDetail(null,taxpayerBusDetail);
    }
}
