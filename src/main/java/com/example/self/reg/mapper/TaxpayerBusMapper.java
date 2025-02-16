package com.example.self.reg.mapper;

import com.example.self.reg.entity.TaxpayerBus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.self.reg.entity.TaxpayerInd;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qiuming
 * @since 2025-01-19
 */
@Mapper
public interface TaxpayerBusMapper extends BaseMapper<TaxpayerBus> {

    TaxpayerBus queryTaxpayerBusInfoByTaxpayerId(String taxpayerId);

}
