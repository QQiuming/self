package com.example.self.reg.service;

import com.example.self.reg.entity.TaxpayerDetail;

/**
 * @descriptions: TaxpayerStrategyService
 * @author: qiuming
 * @date: 2025/1/21 15:19
 * @version: 1.0
 */
public interface TaxpayerStrategyService {

    TaxpayerDetail queryTaxpayerDetail(String taxpayerId);

}
