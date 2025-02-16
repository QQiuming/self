package com.example.self.reg.entity;

import lombok.Data;

/**
 * @descriptions: TaxpayerDetail
 * @author: qiuming
 * @date: 2025/1/21 15:52
 * @version: 1.0
 */
@Data
public class TaxpayerDetail {

    private TaxpayerIndDetail taxpayerIndDetail;

    private TaxpayerBusDetail taxpayerBusDetail;
}
