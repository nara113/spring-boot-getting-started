package com.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertiesRunner implements ApplicationRunner {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }
}
