package com.chen.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring-*.xml"})
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test(){
        redisTemplate.opsForValue().set("chen", "陈海平");

        System.out.println("value："+redisTemplate.opsForValue().get("chen"));
    }
}
