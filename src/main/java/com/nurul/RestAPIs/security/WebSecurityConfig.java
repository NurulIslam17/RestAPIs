package com.nurul.RestAPIs.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

import static com.nurul.RestAPIs.entity.type.RoleType.*;

@Configuration
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final HandlerExceptionResolver handlerExceptionResolver;

    public WebSecurityConfig(JwtAuthFilter jwtAuthFilter, HandlerExceptionResolver handlerExceptionResolver) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**", "/auth/**").permitAll()
                        .requestMatchers("/admin/**").hasRole(ADMIN.name())
                        .requestMatchers("/teacher/**").hasAnyRole(TEACHER.name(), ADMIN.name())
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandlingConfigurer ->
                        exceptionHandlingConfigurer.accessDeniedHandler((request, response, accessDeniedException) -> handlerExceptionResolver.resolveException(request, response, null, accessDeniedException)));
        return httpSecurity.build();
    }
}
