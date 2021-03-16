package com.itcast;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class MyInterceptor {
    @RuntimeType
    public static Object intercept(@Origin Method method,
        @SuperCall Callable<?> callable) {
        // System.out.println("MyInterceptor start...");
        long start = System.currentTimeMillis();
        try {
            //执行原方法
            try {
                if (callable == null) {
                    return null;
                }
                return callable.call();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } finally {
            //打印调用时长
            System.out.println(
                method.getDeclaringClass() + "---" + method.getName() + ":" + (System.currentTimeMillis() - start)
                    + "ms");
            // System.out.println("MyInterceptor end...");
        }
    }
}
