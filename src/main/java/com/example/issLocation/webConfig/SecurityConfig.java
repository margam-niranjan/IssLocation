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
                .csrf(csrf -> csrf.disable()) // Disable CSRF for API access
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/iss").permitAll()  // Allow public access to /iss
                        .requestMatchers("/user-info").permitAll() // Now accessible without authentication
                        .requestMatchers("/images/iss.png").permitAll() // Allow direct image access
                        .anyRequest().authenticated() // Other requests require authentication
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/user-info", true) // Redirect to /user-info after login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Define logout endpoint
                        .logoutSuccessUrl("/iss") // Redirect to /iss after logout
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }
}
