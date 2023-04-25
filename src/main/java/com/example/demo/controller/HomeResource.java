package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return "welcome";
    }

    @GetMapping("/user")
    public String user() {
        return "welcome user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "welcome admin";
    }

}
