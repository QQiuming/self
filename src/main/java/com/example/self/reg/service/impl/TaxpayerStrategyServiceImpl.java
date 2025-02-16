package com.example.self.reg.service.impl;

import com.example.self.reg.entity.TaxpayerBusDetail;
import com.example.self.reg.entity.TaxpayerDetail;
import com.example.self.reg.entity.TaxpayerInd;
import com.example.self.reg.entity.TaxpayerIndDetail;
import com.example.self.reg.service.TaxpayerStrategyService;

/**
 * @descriptions: TaxpayerStrategyServiceImpl
 * @author: qiuming
 * @date: 2025/1/21 15:54
 * @version: 1.0
 */
public abstract class TaxpayerStrategyServiceImpl implements TaxpayerStrategyService {
    @Override
    public TaxpayerDetail queryTaxpayerDetail(String taxpayerId) {
        return null;
    }

    protected TaxpayerDetail combineTaxpayerDetail( TaxpayerIndDetail ind, TaxpayerBusDetail bus){
        TaxpayerDetail detail = new TaxpayerDetail();
        detail.setTaxpayerBusDetail(bus);
        detail.setTaxpayerIndDetail(ind);
        return detail;
    }

}
