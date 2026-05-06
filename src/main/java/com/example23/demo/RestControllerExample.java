package com.example23.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerExample {

    @GetMapping("/")
    public String greet() {
        return "Hello, this Spring Boot app was not updated!";
    }

    @GetMapping("/time")
    public String getTime() {
        return new Date().toString();
    }


}