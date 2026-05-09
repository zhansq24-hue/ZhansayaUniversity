package com.example.zhansayauniversity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ZhansayaStudentDTO {
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, message = "First name should have at least 2 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
}