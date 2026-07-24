package com.example.zhansayauniversity.controller;

import com.example.zhansayauniversity.util.util;
import org.springframework.web.bind.annotation.*;

@RestController // Говорит Spring, что в этом классе живут эндпоинты
@RequestMapping("/api/tasks") // Базовый путь для всех запросов в этом контроллере
public class TaskController {

    // Эндпоинт для факториала (теперь использует исправленный util)
    @GetMapping("/factorial")
    public String calculateFactorial(@RequestParam int number) {
        if (number < 0) {
            return "Ошибка: Число должно быть неотрицательным!";
        }
        long res = util.factorial(number);
        return "Результат факториала для числа " + number + ": " + res;
    }

    // Эндпоинт для проверки четности
    @GetMapping("/is-even")
    public String checkEven(@RequestParam int number) {
        return (number % 2 == 0) ? "Четное" : "Нечетное";
    }
}