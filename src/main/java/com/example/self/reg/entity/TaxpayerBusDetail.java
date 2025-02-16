package com.example.self.reg.entity;

import lombok.Data;

import java.util.List;

/**
 * @descriptions: TaxpayerRelateInd
 * @author: qiuming
 * @date: 2025/1/19 21:17
 * @version: 1.0
 */

@Data
public class TaxpayerBusDetail extends Taxpayer{

    private TaxpayerBus taxpayerBus;

    private List<TaxpayerMember> taxpayerMemberList;

}
