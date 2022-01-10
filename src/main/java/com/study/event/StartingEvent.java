package com.study.event;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

//빈으로 등록해도 의미없다.
public class StartingEvent implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("===============");
        System.out.println("!!STARTING!!");
        System.out.println("===============");
    }
}
