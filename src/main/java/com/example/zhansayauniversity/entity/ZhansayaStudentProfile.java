package com.example.zhansayauniversity.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ZhansayaStudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;           // Краткая биография
    private String phoneNumber;   // Номер телефона
    private String address;       // Адрес проживания

    // Обратная связь со студентом (опционально)
    @OneToOne(mappedBy = "profile")
    private ZhansayaStudent student;
}