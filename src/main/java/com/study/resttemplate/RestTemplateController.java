package com.study.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {

    @GetMapping("/rest")
    private String rest() throws InterruptedException {
        Thread.sleep(3000);
        return "rest";
    }

    @GetMapping("/template")
    public String template() throws InterruptedException {
        Thread.sleep(1000);
        return "template";
    }
}
