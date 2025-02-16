package com.example.self.reg.service;

import com.example.self.reg.entity.TaxpayerBus;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author qiuming
* @since 2025-01-19
*/
    public interface TaxpayerBusService extends IService<TaxpayerBus> {

    /**
    * TaxpayerBus详情
    * @param
    * @return
    */
    TaxpayerBus getTaxpayerBus( Integer id);

    /**
    * TaxpayerBus详情
    * @param
    * @return
    */
    List<TaxpayerBus> getAllTaxpayerBus();

    /**
    * TaxpayerBus新增
    * @param taxpayerBus 根据需要进行传值
    * @return
    */
    void add(TaxpayerBus taxpayerBus);

    /**
    * TaxpayerBus修改
    * @param taxpayerBus 根据需要进行传值
    * @return
    */
    int modify(TaxpayerBus taxpayerBus);

    /**
    * TaxpayerBus删除
    * @param ids
    * @return
    */
    void remove(String ids);
    }


