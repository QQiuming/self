package com.example.self.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @descriptions: DemoController
 * @author: qiuming
 * @date: 2025/1/17 14:42
 * @version: 1.0
 */
@RestController
public class DemoController {


    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
