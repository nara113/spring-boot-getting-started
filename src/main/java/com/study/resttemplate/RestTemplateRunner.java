package com.study.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateRunner implements ApplicationRunner {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final String rest = restTemplate.getForObject("http://localhost:8080/rest", String.class);
        System.out.println("rest : " + rest);

        final String template = restTemplate.getForObject("http://localhost:8080/template", String.class);
        System.out.println("template : " + template);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
