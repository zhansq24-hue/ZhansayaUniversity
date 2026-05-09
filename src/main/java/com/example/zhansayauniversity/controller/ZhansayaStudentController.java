package com.example.zhansayauniversity.controller;

import com.example.zhansayauniversity.dto.ZhansayaStudentDTO;
import com.example.zhansayauniversity.entity.ZhansayaStudent;
import com.example.zhansayauniversity.service.ZhansayaStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class ZhansayaStudentController {

    private final ZhansayaStudentService studentService;

    // 1. GET - Получение всех
    @GetMapping
    public List<ZhansayaStudent> getAllStudents() {
        return studentService.getAllStudents();
    }


    // 2. POST - Создание студента
    @PostMapping
    public String createStudent(@Valid @RequestBody ZhansayaStudentDTO studentDTO) {
        return "Student " + studentDTO.getFirstName() + " was created!";
    }

    // 3. PUT - Обновление студента (используем Path Variable {id})
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @RequestBody ZhansayaStudentDTO studentDTO) {
        return "Student with ID " + id + " was updated!";
    }

    // 4. DELETE - Удаление студента
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return "Student with ID " + id + " was deleted!";
    }

    // --- ЭНДПОИНТ ДЛЯ ПАГИНАЦИИ ---
    @GetMapping("/paged")
    public org.springframework.data.domain.Page<ZhansayaStudent> getStudentsPaged(
            @org.springframework.web.bind.annotation.RequestParam(defaultValue = "0") int page,
            @org.springframework.web.bind.annotation.RequestParam(defaultValue = "5") int size,
            @org.springframework.web.bind.annotation.RequestParam(defaultValue = "id") String sortBy) {
        return studentService.getAllStudentsPaged(page, size, sortBy);
    }
}