package com.example.self.reg.service.impl;

import com.example.self.reg.entity.TaxpayerInd;
import com.example.self.reg.mapper.TaxpayerIndMapper;
import com.example.self.reg.service.TaxpayerIndService;
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
public class TaxpayerIndServiceImpl extends ServiceImpl<TaxpayerIndMapper, TaxpayerInd> implements TaxpayerIndService {

    @Autowired
    TaxpayerIndMapper taxpayerIndMapper;


    @Override
    public TaxpayerInd getTaxpayerInd(Integer id) {

        return taxpayerIndMapper.selectById(id);
    }

    @Override
    public List<TaxpayerInd> getAllTaxpayerInd() {
        return taxpayerIndMapper.selectList(null);

    }

    @Override
    public void add(TaxpayerInd taxpayerInd) {
        taxpayerIndMapper.insert(taxpayerInd);
    }

    @Override
    public int modify(TaxpayerInd taxpayerInd) {
        //乐观锁更新
        TaxpayerInd currentTaxpayerInd = taxpayerIndMapper.selectById(taxpayerInd.getId());
        taxpayerInd.setLockVersion(currentTaxpayerInd.getLockVersion());
        return taxpayerIndMapper.updateById(taxpayerInd);
    }

    @Override
    public void remove(String ids) {

        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                taxpayerIndMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


