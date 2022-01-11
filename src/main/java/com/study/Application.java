package com.study;

import com.study.event.StartingEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //커스터마이징 할 수 있다.
//        new SpringApplicationBuilder()
//                .sources(Application.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);

        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.addListeners(new StartingEvent()); //Application context 생성 전 실행되는 이벤트
        springApplication.setWebApplicationType(WebApplicationType.NONE); //EnableAutoConfiguration이 없어도 실행됨.
        springApplication.run(args);
    }

    @Bean
    public Holoman holoman() {
        return new Holoman("new", 10);
    }
}
