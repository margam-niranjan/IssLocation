package com.example.issLocation.interceptor;

import com.example.issLocation.service.AccessCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private final AccessCountService accessCountService;

    public RequestInterceptor(AccessCountService accessCountService) {
        this.accessCountService = accessCountService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if the request is for the /iss endpoint
        if (request.getRequestURI().equals("/iss")) {
            accessCountService.incrementAccessCount();
        }
        return true; // Continue with the request
    }
}

