package com.example.zhansayauniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "student")
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
    @ManyToMany
    @JoinTable(
            name = "zhansaya_student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonManagedReference
    @JsonIgnore
    private Set<ZhansayaCourse> courses;

}