package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest
public class PropertiesTest {

    @Autowired
    Environment environment;

    @Test
    public void test() {
        assertEquals(environment.getProperty("name"), "test name");
    }
}
