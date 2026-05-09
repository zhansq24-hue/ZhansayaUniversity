package com.example.zhansayauniversity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zhansaya_departments")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ZhansayaDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String officeLocation;
}