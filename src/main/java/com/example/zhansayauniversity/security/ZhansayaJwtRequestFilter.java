package com.example.zhansayauniversity.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ZhansayaJwtRequestFilter extends OncePerRequestFilter {

    private final ZhansayaUserDetailsService userDetailsService;
    private final ZhansayaJwtUtil jwtUtil;

    public ZhansayaJwtRequestFilter(ZhansayaUserDetailsService userDetailsService, ZhansayaJwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // 1. Убираем "Bearer "
            // 2. trim() уберет случайные пробелы в начале и конце
            // 3. replace еще раз подстрахует от двойного "Bearer Bearer"
            jwt = authorizationHeader.substring(7).trim().replace("Bearer ", "");

            try {
                username = jwtUtil.extractUsername(jwt);
                logger.info("Username успешно извлечен: " + username); // Добавь это для проверки в логах
            } catch (Exception e) {
                logger.error("Ошибка в JwtUtil: " + e.getMessage());
            }
        }

        // Валидируем токен и устанавливаем аутентификацию
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        chain.doFilter(request, response);
    }
}