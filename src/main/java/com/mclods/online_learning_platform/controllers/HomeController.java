package com.mclods.online_learning_platform.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String home() {
        return "Welcome to Online Learning Platform Application!";
    }
}
