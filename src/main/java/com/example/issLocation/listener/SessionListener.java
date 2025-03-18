package com.example.issLocation.listener;

import com.example.issLocation.service.AccessCountService;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class SessionListener implements HttpSessionListener {

    private final AccessCountService accessCountService;

    @Autowired
    public SessionListener(AccessCountService accessCountService) {
        this.accessCountService = accessCountService;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created. Incrementing count.");
        accessCountService.incrementAccessCount();  // Increment user count
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed. Decrementing count.");
        accessCountService.decrementAccessCount();  // Decrement user count
    }
}
