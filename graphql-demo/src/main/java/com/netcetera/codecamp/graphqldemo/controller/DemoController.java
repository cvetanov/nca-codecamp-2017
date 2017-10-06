package com.netcetera.codecamp.graphqldemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String helloWorld() {
        return "Hello world!";
    }
}
