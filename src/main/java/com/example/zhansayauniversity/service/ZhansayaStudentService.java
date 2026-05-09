package com.example.zhansayauniversity.service;

import com.example.zhansayauniversity.entity.ZhansayaStudent;
import com.example.zhansayauniversity.repository.ZhansayaStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ZhansayaStudentService {

    private final ZhansayaStudentRepository studentRepository;

    // Возвращаем список Entity напрямую, как и просит контроллер
    public List<ZhansayaStudent> getAllStudents() {
        return studentRepository.findAll();
    }
}