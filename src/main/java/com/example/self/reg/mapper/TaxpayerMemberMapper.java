package com.example.self.reg.mapper;

import com.example.self.reg.entity.TaxpayerMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qiuming
 * @since 2025-01-21
 */
@Mapper
public interface TaxpayerMemberMapper extends BaseMapper<TaxpayerMember> {

    List<TaxpayerMember> queryTaxpayerMemberByTaxpayerId(String taxpayerId);

}
