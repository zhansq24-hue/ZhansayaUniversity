package com.example.zhansayauniversity.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "zhansaya_enrollments")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ZhansayaEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate enrollmentDate;
    private String semester;
}