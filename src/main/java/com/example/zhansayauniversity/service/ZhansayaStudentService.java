package com.example.zhansayauniversity.service;

import com.example.zhansayauniversity.dto.ZhansayaStudentdto;
import com.example.zhansayauniversity.entity.ZhansayaStudent;
import com.example.zhansayauniversity.repository.ZhansayaStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZhansayaStudentService {
    private final ZhansayaStudentRepository studentRepository;

    // Метод для получения всех студентов и превращения их в DTO
    public List<ZhansayaStudentdto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ZhansayaStudentdto convertToDTO(ZhansayaStudent student) {
        ZhansayaStudentdto dto = new ZhansayaStudentdto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        return dto;
    }
}