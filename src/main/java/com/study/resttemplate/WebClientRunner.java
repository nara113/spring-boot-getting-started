package com.study.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientRunner implements ApplicationRunner {

    @Autowired
    private WebClient.Builder builder;

    @Override
    public void run(ApplicationArguments args) {
        final WebClient webClient = builder
                .baseUrl("http://localhost:8080")
                .build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final Mono<String> rest = webClient.get()
                .uri("/rest")
                .retrieve()
                .bodyToMono(String.class);

        rest.subscribe(s -> {
            System.out.println("s : " + s);

            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }

            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });

        webClient.get()
                .uri("/template")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(s -> {
                    System.out.println("s : " + s);

                    if (stopWatch.isRunning()) {
                        stopWatch.stop();
                    }

                    System.out.println(stopWatch.prettyPrint());
                    stopWatch.start();
                });
    }
}
