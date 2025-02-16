package com.example.self.sys.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.self.sys.entity.User;
import com.example.self.sys.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @descriptions: LoginController
 * @author: qiuming
 * @date: 2025/1/18 14:57
 * @version: 1.0
 */
@RestController
@RequestMapping("sys")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public String login(String loginName, String orgId) {
        User user = userService.getOne(new QueryWrapper<User>().eq("login_name", loginName));

        if (Objects.isNull(user)) {
            user = new User();
            user.setLoginName(loginName);
            user.setOrgId(orgId);
            user.setPassword(UUID.fastUUID().toString());
            user.setNickName(loginName + "_" + UUID.fastUUID().toString().substring(0, 4));
            userService.save(user);
        }

        StpUtil.login(user.getId());
        StpUtil.getSession().set("user", user);

        return "success";

    }


}
