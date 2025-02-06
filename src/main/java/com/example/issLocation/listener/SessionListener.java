package com.example.issLocation.listener;

import com.example.issLocation.service.AccessCountService;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener {

    private final AccessCountService accessCountService;

    // Constructor injection of AccessCountService
    public SessionListener(AccessCountService accessCountService) {
        this.accessCountService = accessCountService;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Debugging
        System.out.println("Session Created. Incrementing count.");
        accessCountService.incrementAccessCount();  // Increment user count when session is created
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Debugging
        System.out.println("Session Destroyed. Decrementing count.");
        accessCountService.decrementAccessCount();  // Decrement user count when session is destroyed
    }
}
