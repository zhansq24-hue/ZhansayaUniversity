package com.example.zhansayauniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private ZhansayaStudent student;
}