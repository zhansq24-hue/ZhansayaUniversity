package com.example.zhansayauniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "student") // Теперь точно совпадает с pgAdmin!
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZhansayaStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name") // Указываем точное имя колонки как в БД
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private ZhansayaStudentProfile profile;

}