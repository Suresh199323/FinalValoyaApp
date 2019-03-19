package com.example.gallary.gallery.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class Hello {

    @PostMapping
    public String hello() {
        return "Hello World";
    }
}