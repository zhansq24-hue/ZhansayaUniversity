package com.example.zhansayauniversity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZhansayaStudentController {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello Professor! My name is Zhansaya, and my project is working!";
    }
}