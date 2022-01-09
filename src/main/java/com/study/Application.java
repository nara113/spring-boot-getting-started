package com.study;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //커스터마이징 할 수 있다.
        new SpringApplicationBuilder()
                .sources(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

//        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.setWebApplicationType(WebApplicationType.NONE); //EnableAutoConfiguration이 없어도 실행됨.
//        springApplication.run(args);
    }

    @Bean
    public Holoman holoman() {
        return new Holoman("new", 10);
    }
}
