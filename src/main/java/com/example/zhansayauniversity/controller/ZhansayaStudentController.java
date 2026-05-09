package com.example.zhansayauniversity.controller;

import com.example.zhansayauniversity.entity.ZhansayaStudent;
import com.example.zhansayauniversity.service.ZhansayaStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ZhansayaStudentController {

    private final ZhansayaStudentService studentService;

    @GetMapping("/api/students")
    public List<ZhansayaStudent> getAllStudents() {
        return studentService.getAllStudents();
    }
}