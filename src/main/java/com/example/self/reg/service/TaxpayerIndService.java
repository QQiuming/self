package com.example.self.reg.service;

import com.example.self.reg.entity.TaxpayerInd;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author qiuming
* @since 2025-01-19
*/
    public interface TaxpayerIndService extends IService<TaxpayerInd> {

    /**
    * TaxpayerInd详情
    * @param
    * @return
    */
    TaxpayerInd getTaxpayerInd( Integer id);

    /**
    * TaxpayerInd详情
    * @param
    * @return
    */
    List<TaxpayerInd> getAllTaxpayerInd();

    /**
    * TaxpayerInd新增
    * @param taxpayerInd 根据需要进行传值
    * @return
    */
    void add(TaxpayerInd taxpayerInd);

    /**
    * TaxpayerInd修改
    * @param taxpayerInd 根据需要进行传值
    * @return
    */
    int modify(TaxpayerInd taxpayerInd);

    /**
    * TaxpayerInd删除
    * @param ids
    * @return
    */
    void remove(String ids);
    }


