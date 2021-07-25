package com.example.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settlement") // localhost:8080/settlement
public class Settlement {
    @RequestMapping(method = RequestMethod.GET, path = "") // localhost:8080/settlement/
    public String getRequest() {
        return "Hi, settlement!";
    }
}
