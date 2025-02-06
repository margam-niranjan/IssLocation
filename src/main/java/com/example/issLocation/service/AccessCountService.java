package com.example.issLocation.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccessCountService {
    private AtomicInteger activeUserCount = new AtomicInteger(0);

    public void incrementAccessCount() {
        int count = activeUserCount.incrementAndGet();
        System.out.println("Active Users Count (Incremented): " + count);  // Debugging
    }

    public void decrementAccessCount() {
        int count = activeUserCount.decrementAndGet();
        System.out.println("Active Users Count (Decremented): " + count);  // Debugging
    }

    public int getAccessCount() {
        return activeUserCount.get();
    }
}
