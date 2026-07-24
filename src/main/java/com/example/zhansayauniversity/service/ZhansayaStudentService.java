package com.example.zhansayauniversity.service;

import com.example.zhansayauniversity.dto.ZhansayaStudentDTO;
import com.example.zhansayauniversity.entity.ZhansayaStudent;
import com.example.zhansayauniversity.repository.ZhansayaStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ZhansayaStudentService {

    private final ZhansayaStudentRepository studentRepository;

    public List<ZhansayaStudent> getAllStudents() {
        return studentRepository.findAll();
    }

    // 1. Метод для СОЗДАНИЯ (POST)
    public ZhansayaStudent createStudent(ZhansayaStudentDTO dto) {
        ZhansayaStudent student = new ZhansayaStudent();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        if (dto.getProfile() != null) {
            com.example.zhansayauniversity.entity.ZhansayaStudentProfile profile = dto.getProfile();
            profile.setStudent(student); // Привязываем студента к профилю
            student.setProfile(profile); // Привязываем профиль к студенту
        }
        return studentRepository.save(student);

    }

    // 2. Метод для ОБНОВЛЕНИЯ (PUT)
    public ZhansayaStudent updateStudent(Long id, ZhansayaStudentDTO dto) {
        ZhansayaStudent student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        if (dto.getProfile() != null) {
            com.example.zhansayauniversity.entity.ZhansayaStudentProfile profile = dto.getProfile();
            profile.setStudent(student);
            student.setProfile(profile);
        }
        return studentRepository.save(student);
    }

    // 3. Метод для УДАЛЕНИЯ (DELETE)
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Метод для пагинации (у тебя он был в контроллере)
    public org.springframework.data.domain.Page<ZhansayaStudent> getAllStudentsPaged(int page, int size, String sortBy) {
        return studentRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size, org.springframework.data.util.Streamable.of(sortBy).stream().findFirst().map(org.springframework.data.domain.Sort::by).orElse(org.springframework.data.domain.Sort.unsorted())));
    }
}