package com.example.issLocation.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/iss").permitAll()  // Allow access to /iss
                        .anyRequest().authenticated()        // Require authentication for other pages
                )
                .formLogin()  // Enable login form
                .and()
                .logout();

        return http.build();
    }
}
