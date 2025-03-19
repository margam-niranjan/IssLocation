package com.example.issLocation.listener;

import com.example.issLocation.service.AccessCountService;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionListener implements HttpSessionListener {

    private final AccessCountService accessCountService;

    @Autowired
    public SessionListener(AccessCountService accessCountService) {
        this.accessCountService = accessCountService;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        accessCountService.incrementAccessCount();  // Increment user count
        System.out.println("[SESSION CREATED] Active Users: " + accessCountService.getCurrentAccessCount());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        accessCountService.decrementAccessCount();  // Decrement user count
        System.out.println("[SESSION DESTROYED] Active Users: " + accessCountService.getCurrentAccessCount());
    }
}
