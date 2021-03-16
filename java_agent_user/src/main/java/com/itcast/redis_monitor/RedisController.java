package com.itcast.redis_monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping(value = "/v1/rtc/inner/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "/test")
    public void testAkSkSigner() {

        for (int i = 0; i < 1; i++) {
            // redisTemplate.opsForValue().set("aaa", "aaa");
            redisTemplate.opsForValue().get("aaa");
        }
    }

}
