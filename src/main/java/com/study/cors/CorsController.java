package com.study.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

    @CrossOrigin("http://localhost:8081")
    @GetMapping("/cors")
    public String cors() {
        return "cors";
    }
}
