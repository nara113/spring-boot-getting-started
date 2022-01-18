package com.study.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest    //슬라이스 테스트에서는 임베디드 db 사용
class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void test() throws SQLException {
        try(final Connection connection = dataSource.getConnection()) {
            System.out.println(connection.getMetaData().getDriverName());
            System.out.println(connection.getMetaData().getUserName());
        }
    }

    @Test
    void test2() {
        Account account = new Account(1L, "hi");

        final Account realAccount = accountRepository.save(account);
        assertNotNull(realAccount);
        assertEquals(realAccount.getUserName(), "hi");

        final Optional<Account> testUser = accountRepository.findByUserName(realAccount.getUserName());
        assertTrue(testUser.isPresent());

        final Optional<Account> noUser = accountRepository.findByUserName("test");
        assertTrue(noUser.isEmpty());
        assertThat(noUser).isEmpty();
    }
}