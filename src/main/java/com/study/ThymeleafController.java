package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    @GetMapping("/name")
    public String getHello(Model model) {
        model.addAttribute("name", "me");
        return "hello";
    }

    @GetMapping("/error")
    public String getError() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody
    MyError error(SampleException e) {
        return new MyError("error");
    }
}
