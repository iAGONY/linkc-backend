package com.linkc.linkcbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class TestController {

    @GetMapping
    public String echo() {
        return "Hello World";
    }
}
