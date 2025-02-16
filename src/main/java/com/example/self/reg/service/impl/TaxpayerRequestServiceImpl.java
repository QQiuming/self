package com.example.self.reg.service.impl;

import com.example.self.reg.entity.TaxpayerRequest;
import com.example.self.reg.mapper.TaxpayerRequestMapper;
import com.example.self.reg.service.TaxpayerRequestService;
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
public class TaxpayerRequestServiceImpl extends ServiceImpl<TaxpayerRequestMapper, TaxpayerRequest> implements TaxpayerRequestService {

    @Autowired
    TaxpayerRequestMapper taxpayerRequestMapper;


    @Override
    public TaxpayerRequest getTaxpayerRequest(Integer id) {

        return taxpayerRequestMapper.selectById(id);
    }

    @Override
    public List<TaxpayerRequest> getAllTaxpayerRequest() {
        return taxpayerRequestMapper.selectList(null);

    }

    @Override
    public void add(TaxpayerRequest taxpayerRequest) {
        taxpayerRequestMapper.insert(taxpayerRequest);
    }

    @Override
    public int modify(TaxpayerRequest taxpayerRequest) {
        //乐观锁更新
        TaxpayerRequest currentTaxpayerRequest = taxpayerRequestMapper.selectById(taxpayerRequest.getId());
        taxpayerRequest.setLockVersion(currentTaxpayerRequest.getLockVersion());
        return taxpayerRequestMapper.updateById(taxpayerRequest);
    }

    @Override
    public void remove(String ids) {

        if (StringUtils.isNotEmpty(ids)) {
            String[] array = ids.split(",");
            if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
                taxpayerRequestMapper.deleteBatchIds(Arrays.asList(array));
            }
        }

    }

}


