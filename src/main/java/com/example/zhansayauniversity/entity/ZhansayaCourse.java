package com.example.zhansayauniversity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zhansaya_courses")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ZhansayaCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String courseCode;
    private Integer credits;
}