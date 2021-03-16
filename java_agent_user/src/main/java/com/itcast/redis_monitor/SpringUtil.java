/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.itcast.redis_monitor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author l00383789
 */
public class SpringUtil {

    public static ApplicationContext getApplicationContext() {
        return ApplicationContextHolder.getApplicationContext();
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    public static void close() {
        if (getApplicationContext() instanceof ConfigurableApplicationContext) {
            ((ConfigurableApplicationContext) getApplicationContext()).close();
        }

    }
}