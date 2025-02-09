package com.example.issLocation.interceptor;

import com.example.issLocation.service.AccessCountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

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
        return true;
    }
}

