package com.example.zhansayauniversity.controller;

import com.example.zhansayauniversity.dto.ZhansayaAuthRequest;
import com.example.zhansayauniversity.security.ZhansayaJwtUtil;
import com.example.zhansayauniversity.security.ZhansayaUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class ZhansayaAuthController {

    private final AuthenticationManager authenticationManager;
    private final ZhansayaUserDetailsService userDetailsService;
    private final ZhansayaJwtUtil jwtUtil;

    public ZhansayaAuthController(AuthenticationManager authenticationManager,
                                  ZhansayaUserDetailsService userDetailsService,
                                  ZhansayaJwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

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
}