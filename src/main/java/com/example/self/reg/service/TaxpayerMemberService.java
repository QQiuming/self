package com.example.self.reg.service;

import com.example.self.reg.entity.TaxpayerMember;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author qiuming
* @since 2025-01-21
*/
    public interface TaxpayerMemberService extends IService<TaxpayerMember> {

    /**
    * TaxpayerMember详情
    * @param
    * @return
    */
    TaxpayerMember getTaxpayerMember( Integer id);

    /**
    * TaxpayerMember详情
    * @param
    * @return
    */
    List<TaxpayerMember> getAllTaxpayerMember();

    /**
    * TaxpayerMember新增
    * @param taxpayerMember 根据需要进行传值
    * @return
    */
    void add(TaxpayerMember taxpayerMember);

    /**
    * TaxpayerMember修改
    * @param taxpayerMember 根据需要进行传值
    * @return
    */
    int modify(TaxpayerMember taxpayerMember);

    /**
    * TaxpayerMember删除
    * @param ids
    * @return
    */
    void remove(String ids);
    }


