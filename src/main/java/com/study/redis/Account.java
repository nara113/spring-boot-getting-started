package com.study.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@Setter
@RedisHash("accounts")
public class Account {
    @Id
    private String id;

    private String redisName;
}
