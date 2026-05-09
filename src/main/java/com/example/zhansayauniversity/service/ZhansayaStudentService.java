package com.example.zhansayauniversity.service;

import com.example.zhansayauniversity.entity.ZhansayaStudent;
import com.example.zhansayauniversity.repository.ZhansayaStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// --- НОВЫЕ ИМПОРТЫ ДЛЯ ПАГИНАЦИИ ---
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZhansayaStudentService {

    private final ZhansayaStudentRepository studentRepository;

    // 1. Старый метод (оставляем, он работает)
    public List<ZhansayaStudent> getAllStudents() {
        return studentRepository.findAll();
    }

    // 2. --- НОВЫЙ МЕТОД (Пагинация и Сортировка) ---
    public Page<ZhansayaStudent> getAllStudentsPaged(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studentRepository.findAll(pageable);
    }
}