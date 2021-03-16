package com.itcast.redis_monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Controller(value = "")
@Slf4j
public class KafkaTestController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/kafka/test", method = RequestMethod.GET)
    @ResponseBody
    public void testRedisTemplete() {
        //获取过滤器的requestId
        //使用kafka模拟 先add  再delete操作
        ListenableFuture future;
        String key = UUID.randomUUID().toString();
        log.info("生产数据中~~~~~~~~key:{}", key);
        try {
            future = kafkaTemplate.send("product", "mykey", "kafka test");
            future.addCallback(new MyListenableFutureCallback());
            //阻塞等待结果
            future.get(10, TimeUnit.SECONDS);
            log.info("success send data: {}");
        } catch (Exception e) {
            log.error("kafkaTemplate send error:{}", e);
            return;
        }
    }


    public class MyListenableFutureCallback implements ListenableFutureCallback {

        @Override
        public void onFailure(Throwable throwable) {
            log.info("onFailure");
        }

        @Override
        public void onSuccess(Object o) {
            log.info("onSuccess" + o.toString());
        }
    }
}