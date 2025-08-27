package com.kevinpe.task_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // keep session based auth disabled since not using cookies.
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // all requests in task-service should be validated against the JWT from auth-service.
                )
                // keep basic auth disabled since using JWT based auth.
                .httpBasic(httpBasicAuth -> httpBasicAuth.disable())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
