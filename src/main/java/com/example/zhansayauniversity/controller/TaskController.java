package com.example.zhansayauniversity.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    // 1. Факториал числа (Задача №1)
    @GetMapping("/factorial/{n}")
    public long getFactorial(@PathVariable int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}