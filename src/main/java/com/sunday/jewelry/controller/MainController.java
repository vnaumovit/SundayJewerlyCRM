package com.sunday.jewelry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String itemPage() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "authentication/login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "authentication/registration";
    }
}
