package com.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertiesRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(PropertiesRunner.class);

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @Autowired
    private String hello;

    @Autowired
    private TestProperties testProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("=======================");
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("test name : " + testProperties.getName());
        System.out.println("test age : " + testProperties.getAge());
        System.out.println("test second : " + testProperties.getSecond());
        System.out.println("hello : " + hello);
        logger.info("hello : {}", hello);
        logger.info("=======================");
    }
}
