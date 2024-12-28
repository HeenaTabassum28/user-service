package com.example.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhiteLabelController {

    @GetMapping("/")
    public String hello() {
        return "Hello , I am listening for white label";
    }
}
