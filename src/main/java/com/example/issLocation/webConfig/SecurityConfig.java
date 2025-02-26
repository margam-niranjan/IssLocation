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
                        .requestMatchers("/iss").permitAll()  // Allow public access to /iss
                        .requestMatchers("/user-info").authenticated() // Require login for /user-info
                        .anyRequest().permitAll() // Allow all requests (we'll handle redirects separately)
                )
                .formLogin()
                .defaultSuccessUrl("/user-info", true) // Redirect to /user-info after login
                .and()
                .logout();

        return http.build();
    }
}
