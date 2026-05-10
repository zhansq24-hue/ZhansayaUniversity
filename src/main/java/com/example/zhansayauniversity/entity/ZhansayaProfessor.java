package com.example.zhansayauniversity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zhansaya_professors")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ZhansayaProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String academicTitle; // например, PhD или Master
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private ZhansayaDepartment department;
}