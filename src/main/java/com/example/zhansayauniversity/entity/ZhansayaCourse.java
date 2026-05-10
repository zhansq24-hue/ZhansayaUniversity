package com.example.zhansayauniversity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore // И здесь
    private Set<ZhansayaStudent> students;
}