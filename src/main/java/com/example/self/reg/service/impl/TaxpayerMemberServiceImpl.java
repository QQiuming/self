package com.example.self.reg.service.impl;

import com.example.self.reg.entity.TaxpayerMember;
import com.example.self.reg.mapper.TaxpayerMemberMapper;
import com.example.self.reg.service.TaxpayerMemberService;
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
    public class TaxpayerMemberServiceImpl extends ServiceImpl<TaxpayerMemberMapper, TaxpayerMember> implements TaxpayerMemberService {

    @Autowired
    TaxpayerMemberMapper taxpayerMemberMapper;


    @Override
    public TaxpayerMember getTaxpayerMember(Integer id){

    return taxpayerMemberMapper.selectById(id);
    }
    @Override
    public List<TaxpayerMember> getAllTaxpayerMember(){
    return taxpayerMemberMapper.selectList(null);

    }

    @Override
    public void add( TaxpayerMember taxpayerMember) {
    taxpayerMemberMapper.insert(taxpayerMember);
    }
    @Override
    public int modify( TaxpayerMember taxpayerMember) {
    //乐观锁更新
    TaxpayerMember currentTaxpayerMember= taxpayerMemberMapper.selectById(taxpayerMember.getId());
    taxpayerMember.setLockVersion(currentTaxpayerMember.getLockVersion());
    return  taxpayerMemberMapper.updateById(taxpayerMember);
    }

    @Override
    public void remove( String ids) {

    if(StringUtils.isNotEmpty(ids)){
    String[] array = ids.split(",");
    if (!CollectionUtils.isEmpty(Arrays.asList(array))) {
    taxpayerMemberMapper.deleteBatchIds(Arrays.asList(array));
    }
    }

    }

    }


