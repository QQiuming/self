package com.example.self.reg.service;

import com.example.self.reg.entity.TaxpayerRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author qiuming
* @since 2025-01-19
*/
    public interface TaxpayerRequestService extends IService<TaxpayerRequest> {

    /**
    * TaxpayerRequest详情
    * @param
    * @return
    */
    TaxpayerRequest getTaxpayerRequest( Integer id);

    /**
    * TaxpayerRequest详情
    * @param
    * @return
    */
    List<TaxpayerRequest> getAllTaxpayerRequest();

    /**
    * TaxpayerRequest新增
    * @param taxpayerRequest 根据需要进行传值
    * @return
    */
    void add(TaxpayerRequest taxpayerRequest);

    /**
    * TaxpayerRequest修改
    * @param taxpayerRequest 根据需要进行传值
    * @return
    */
    int modify(TaxpayerRequest taxpayerRequest);

    /**
    * TaxpayerRequest删除
    * @param ids
    * @return
    */
    void remove(String ids);
    }


