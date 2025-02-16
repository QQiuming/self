package com.example.self.reg.service;

import com.example.self.reg.entity.Taxpayer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.self.reg.entity.TaxpayerBusDetail;
import com.example.self.reg.entity.TaxpayerDetail;
import com.example.self.reg.entity.TaxpayerIndDetail;

import java.util.List;

/**
 * @author qiuming
 * @since 2025-01-19
 */
public interface TaxpayerService extends IService<Taxpayer> {

    /**
     * Taxpayer详情
     *
     * @param
     * @return
     */
    Taxpayer getTaxpayer(Integer id);

    /**
     * Taxpayer详情
     *
     * @param
     * @return
     */
    List<Taxpayer> getAllTaxpayer();

    /**
     * Taxpayer新增
     *
     * @param taxpayer 根据需要进行传值
     * @return
     */
    void add(Taxpayer taxpayer);

    /**
     * Taxpayer修改
     *
     * @param taxpayer 根据需要进行传值
     * @return
     */
    int modify(Taxpayer taxpayer);

    /**
     * Taxpayer删除
     *
     * @param ids
     * @return
     */
    void remove(String ids);

    TaxpayerIndDetail queryTaxpayerIndInfoByBizId(String taxpayerId);


    TaxpayerBusDetail queryTaxpayerBusInfoByBizId(String taxpayerId);

    TaxpayerDetail queryTaxpayerInfoByBizId(String taxpayerId);

    Taxpayer queryTaxpayerByBizId(String taxpayerId);
}


