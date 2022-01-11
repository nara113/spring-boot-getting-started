package com.study.mvc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcController {

    @PostMapping("/user/create")
    public User createUser(@RequestBody User user) {
        System.out.println(user);

        return user;
    }
}
