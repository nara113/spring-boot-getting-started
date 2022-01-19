package com.study;

import com.study.event.StartingEvent;
import com.study.mongo.Account;
import com.study.mongo.AccountMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;


@SpringBootApplication
public class Application {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountMongoRepository mongoRepository;

    public static void main(String[] args) {
        //커스터마이징 할 수 있다.
//        new SpringApplicationBuilder()
//                .sources(Application.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);

        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.addListeners(new StartingEvent()); //Application context 생성 전 실행되는 이벤트
//        springApplication.setWebApplicationType(WebApplicationType.NONE); //EnableAutoConfiguration이 없어도 실행됨.
        springApplication.run(args);
    }

    @Bean
    public Holoman holoman() {
        return new Holoman("new", 10);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setName("mongo");
            account.setEmail("mongo email");

            mongoTemplate.insert(account);

            Account account2 = new Account();
            account2.setName("name 2");
            account2.setEmail("email 2");

            mongoRepository.save(account2);
        };
    }
}
