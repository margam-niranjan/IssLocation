package com.example.issLocation.webConfig;

import com.example.issLocation.listener.SessionListener;
import com.example.issLocation.service.AccessCountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AccessCountService accessCountService;

    @Autowired
    public WebConfig(AccessCountService accessCountService) {
        this.accessCountService = accessCountService;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow CORS on all endpoints
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String path = request.getRequestURI();

                // Allow specific paths without redirection
                if (!path.startsWith("/iss") && !path.startsWith("/user-info") &&
                        !path.equals("/robots.txt") && !path.startsWith("/images/iss.png")) {
                    response.sendRedirect("/iss");
                    return false;
                }
                return true;
            }
        });
    }

    @Bean
    public ServletListenerRegistrationBean<SessionListener> sessionListener(AccessCountService accessCountService) {
        return new ServletListenerRegistrationBean<>(new SessionListener(accessCountService));
    }
}
