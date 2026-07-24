package com.example.zhansayauniversity.controller;

import com.example.zhansayauniversity.dto.ZhansayaAuthRequest;
import com.example.zhansayauniversity.entity.ZhansayaStudent;
import com.example.zhansayauniversity.repository.ZhansayaStudentRepository;
import com.example.zhansayauniversity.security.ZhansayaJwtUtil;
import com.example.zhansayauniversity.security.ZhansayaUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class ZhansayaAuthController {

    private final AuthenticationManager authenticationManager;
    private final ZhansayaUserDetailsService userDetailsService;
    private final ZhansayaJwtUtil jwtUtil;
    private final ZhansayaStudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    // Внедряем все нужные зависимости через конструктор
    public ZhansayaAuthController(AuthenticationManager authenticationManager,
                                  ZhansayaUserDetailsService userDetailsService,
                                  ZhansayaJwtUtil jwtUtil,
                                  ZhansayaStudentRepository studentRepository,
                                  PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 1. Вход (Логин)
    @PostMapping("/login")
    public String login(@RequestBody ZhansayaAuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtUtil.generateToken(userDetails);
    }

    // 2. Регистрация нового студента/пользователя
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ZhansayaAuthRequest authRequest) {
        ZhansayaStudent student = new ZhansayaStudent();
        student.setEmail(authRequest.getUsername()); // или другое поле имени
        // Хэшируем пароль перед сохранением в базу
        // student.setPassword(passwordEncoder.encode(authRequest.getPassword()));

        studentRepository.save(student);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован!");
    }
}
