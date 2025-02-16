package com.example.self.reg.service.impl;

import com.example.self.reg.entity.TaxpayerBus;
import com.example.self.reg.mapper.TaxpayerBusMapper;
import com.example.self.reg.service.TaxpayerBusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Arrays;

/**
 * 服务实现类
 *
 * @author qiuming
 * @since 2025-01-19
 */
@Service
public class TaxpayerBusServiceImpl extends ServiceImpl<TaxpayerBusMapper, TaxpayerBus> implements TaxpayerBusService {

    @Autowired
    TaxpayerBusMapper taxpayerBusMapper;


    @Override
    public TaxpayerBus getTaxpayerBus(Integer id) {

        return taxpayerBusMapper.selectById(id);
    }

    @Override
    public List<TaxpayerBus> getAllTaxpayerBus() {
        return taxpayerBusMapper.selectList(null);

    }

    @Override
    public void add(TaxpayerBus taxpayerBus) {
        taxpayerBusMapper.insert(taxpayerBus);
    }

    @Override
    public int modify(TaxpayerBus taxpayerBus) {
        //乐观锁更新
        TaxpayerBus currentTaxpayerBus = taxpayerBusMapper.selectById(taxpayerBus.getId());
        taxpayerBus.setLockVersion(currentTaxpayerBus.getLockVersion());
        return taxpayerBusMapper.updateById(taxpayerBus);
    }

    @Override
    public void remove(String ids) {

        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                taxpayerBusMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


