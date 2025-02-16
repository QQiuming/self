package com.example.self.sys.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @descriptions: SaTokenConfigure
 * @author: qiuming
 * @date: 2025/1/18 15:24
 * @version: 1.0
 */
@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    private static final String[] IGNORE_PATHS = {
            "/sys/login",
            "/sys/register"
    };
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns(IGNORE_PATHS);
    }




}
