package com.example.self.reg.service;

import com.example.self.reg.entity.TaxpayerStakeholder;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author qiuming
* @since 2025-01-21
*/
    public interface TaxpayerStakeholderService extends IService<TaxpayerStakeholder> {

    /**
    * TaxpayerStakeholder详情
    * @param
    * @return
    */
    TaxpayerStakeholder getTaxpayerStakeholder( Integer id);

    /**
    * TaxpayerStakeholder详情
    * @param
    * @return
    */
    List<TaxpayerStakeholder> getAllTaxpayerStakeholder();

    /**
    * TaxpayerStakeholder新增
    * @param taxpayerStakeholder 根据需要进行传值
    * @return
    */
    void add(TaxpayerStakeholder taxpayerStakeholder);

    /**
    * TaxpayerStakeholder修改
    * @param taxpayerStakeholder 根据需要进行传值
    * @return
    */
    int modify(TaxpayerStakeholder taxpayerStakeholder);

    /**
    * TaxpayerStakeholder删除
    * @param ids
    * @return
    */
    void remove(String ids);
    }


