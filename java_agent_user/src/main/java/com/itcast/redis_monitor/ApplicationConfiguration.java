/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.itcast.redis_monitor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * 系统应用基础配置，包括初始化配置，数据源等
 * 1、配置数据源
 * 2、初始化拦截器
 * 3、初始化定时监控线程
 * 4、初始化统一线程池
 *
 * @author l00383789
 */
@Slf4j
@Configuration
public class ApplicationConfiguration {

    @Bean
    public ApplicationContextHolder initContextHolder() {
        return new ApplicationContextHolder();
    }

}