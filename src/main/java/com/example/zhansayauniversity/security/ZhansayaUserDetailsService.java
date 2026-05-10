package com.example.zhansayauniversity.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ZhansayaUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            // Замени обычный "password" на этот зашифрованный код:
            String encodedPassword = new BCryptPasswordEncoder().encode("password");

            return new User("admin", encodedPassword, new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}