package com.study.mongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
class AccountMongoRepositoryTest {

    @Autowired
    AccountMongoRepository mongoRepository;

    @Test
    void test() {
        Account account = new Account();
        account.setName("test");
        account.setEmail("test email");

        mongoRepository.save(account);

        final Optional<Account> findAccount = mongoRepository.findById(account.getId());

        assertTrue(findAccount.isPresent());

        final Optional<Account> byEmail = mongoRepository.findByEmail(account.getEmail());

        assertTrue(byEmail.isPresent());
        assertEquals(byEmail.get().getName(), "test");
    }
}