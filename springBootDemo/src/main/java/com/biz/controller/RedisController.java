package com.biz.controller;

import com.biz.pojo.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/test")
    public JSONResult test(){
        redisTemplate.opsForValue().set("biz-cache","hello,lmj");
        return JSONResult.ok(redisTemplate.opsForValue().get("biz-cache"));
    }
}
