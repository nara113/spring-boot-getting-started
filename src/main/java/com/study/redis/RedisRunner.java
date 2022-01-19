package com.study.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRedisRepository redisRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hi", "hello");
        valueOperations.set("hello", "hi2");

        Account account = new Account();
        account.setRedisName("redis name");
        final Account save = redisRepository.save(account);

        final Optional<Account> findAccount = redisRepository.findById(save.getId());
        System.out.println(findAccount.get().getId());
        System.out.println(findAccount.get().getRedisName());
    }
}
