package com.itcast.redis_monitor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author x00293445
 * @date 2018/11/23
 */
@Slf4j
@Getter
@Deprecated //applicationContex 服务内自己注入使用更方便
public class ApplicationContextHolder implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
            public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}