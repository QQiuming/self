package com.example.self.reg.mapper;

import com.example.self.reg.entity.TaxpayerStakeholder;
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
public interface TaxpayerStakeholderMapper extends BaseMapper<TaxpayerStakeholder> {

    List<TaxpayerStakeholder> queryTaxpayerStakeholderByTaxpayerId(String taxpayerId);

}
