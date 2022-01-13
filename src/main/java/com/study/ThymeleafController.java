package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("name")
    public String getHello(Model model) {
        model.addAttribute("name", "me");
        return "hello";
    }
}
