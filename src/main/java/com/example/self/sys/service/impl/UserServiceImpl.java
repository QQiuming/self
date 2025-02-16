package com.example.self.sys.service.impl;

import com.example.self.sys.entity.User;
import com.example.self.sys.mapper.UserMapper;
import com.example.self.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiuming
 * @since 2025-01-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
