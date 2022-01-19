package com.study.redis;

import org.springframework.data.repository.CrudRepository;

public interface AccountRedisRepository extends CrudRepository<Account, String> {
}
