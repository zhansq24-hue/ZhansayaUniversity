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

    // GET - Получение всех
    @GetMapping
    public List<ZhansayaStudent> getAllStudents() {
        return studentService.getAllStudents();
    }


    // POST - Создание студента (Теперь по-настоящему!)
    @PostMapping
    public ZhansayaStudent createStudent(@Valid @RequestBody ZhansayaStudentDTO studentDTO) {
        return studentService.createStudent(studentDTO); // Вызываем сервис для сохранения
    }

    // PUT - Обновление студента
    @PutMapping("/{id}")
    public ZhansayaStudent updateStudent(@PathVariable Long id, @Valid @RequestBody ZhansayaStudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO); // Теперь обновляет в базе
    }

    // DELETE - Удаление студента
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id); // Теперь реально удаляет из базы
    }

    // ЭНДПОИНТ ДЛЯ ПАГИНАЦИИ
    @GetMapping("/paged")
    public org.springframework.data.domain.Page<ZhansayaStudent> getStudentsPaged(
            @org.springframework.web.bind.annotation.RequestParam(defaultValue = "0") int page,
            @org.springframework.web.bind.annotation.RequestParam(defaultValue = "5") int size,
            @org.springframework.web.bind.annotation.RequestParam(defaultValue = "id") String sortBy) {
        return studentService.getAllStudentsPaged(page, size, sortBy);
    }
}