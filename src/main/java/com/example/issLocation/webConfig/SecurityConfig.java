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
                .csrf(csrf -> csrf.disable()) // Disable CSRF for easier API access
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/iss", "/user-info", "/images/iss.png").permitAll() // Allow public access
                        .anyRequest().authenticated() // Authenticate all other requests
                )
                .formLogin(login -> login
                        .loginPage("/login") // Ensure you have a login page
                        .defaultSuccessUrl("/user-info", true) // Redirect to /user-info after login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Define logout endpoint
                        .logoutSuccessUrl("/iss") // Redirect to /iss after logout
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }
}
