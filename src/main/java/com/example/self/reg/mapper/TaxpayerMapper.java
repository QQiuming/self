package com.example.self.reg.mapper;

import com.example.self.reg.entity.Taxpayer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.self.reg.entity.TaxpayerBusDetail;
import com.example.self.reg.entity.TaxpayerIndDetail;
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
public interface TaxpayerMapper extends BaseMapper<Taxpayer> {

    TaxpayerIndDetail queryTaxpayerIndInfoByBizId(String bizId);

    TaxpayerBusDetail queryTaxpayerBusInfoByBizId(String bizId);

}
