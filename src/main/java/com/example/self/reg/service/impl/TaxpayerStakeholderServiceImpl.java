package com.example.self.reg.service.impl;

import com.example.self.reg.entity.TaxpayerStakeholder;
import com.example.self.reg.mapper.TaxpayerStakeholderMapper;
import com.example.self.reg.service.TaxpayerStakeholderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Arrays;
/**
*  服务实现类
*
* @author qiuming
* @since 2025-01-21
*/
@Service
    public class TaxpayerStakeholderServiceImpl extends ServiceImpl<TaxpayerStakeholderMapper, TaxpayerStakeholder> implements TaxpayerStakeholderService {

    @Autowired
    TaxpayerStakeholderMapper taxpayerStakeholderMapper;


    @Override
    public TaxpayerStakeholder getTaxpayerStakeholder(Integer id){

    return taxpayerStakeholderMapper.selectById(id);
    }
    @Override
    public List<TaxpayerStakeholder> getAllTaxpayerStakeholder(){
    return taxpayerStakeholderMapper.selectList(null);

    }

    @Override
    public void add( TaxpayerStakeholder taxpayerStakeholder) {
    taxpayerStakeholderMapper.insert(taxpayerStakeholder);
    }
    @Override
    public int modify( TaxpayerStakeholder taxpayerStakeholder) {
    //乐观锁更新
    TaxpayerStakeholder currentTaxpayerStakeholder= taxpayerStakeholderMapper.selectById(taxpayerStakeholder.getId());
    taxpayerStakeholder.setLockVersion(currentTaxpayerStakeholder.getLockVersion());
    return  taxpayerStakeholderMapper.updateById(taxpayerStakeholder);
    }

    @Override
    public void remove( String ids) {

    if(StringUtils.isNotEmpty(ids)){
    String[] array = ids.split(",");
    if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
    taxpayerStakeholderMapper.deleteBatchIds(Arrays.asList(array));
    }
    }

    }

    }


