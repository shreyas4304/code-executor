
package com.example.codeexecutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueService {

@Autowired
private StringRedisTemplate redisTemplate;

private static final String QUEUE = "code_queue";

public void push(String job) {
redisTemplate.opsForList().rightPush(QUEUE, job);
}

public String pop() {
return redisTemplate.opsForList().leftPop(QUEUE);
}
}
