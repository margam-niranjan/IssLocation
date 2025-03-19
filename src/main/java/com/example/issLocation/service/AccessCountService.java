package com.example.issLocation.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccessCountService {
    private AtomicInteger activeUserCount = new AtomicInteger(0);

    public void incrementAccessCount() {
        int count = activeUserCount.incrementAndGet();
        System.out.println("Active Users Count (Incremented): " + count);
    }

    public void decrementAccessCount() {
        int current;
        do {
            current = activeUserCount.get();
            if (current == 0) {
                System.out.println("Active Users Count (Decremented): " + current);
                return; // Prevent decrementing below zero
            }
        } while (!activeUserCount.compareAndSet(current, current - 1));

        System.out.println("Active Users Count (Decremented): " + (current - 1));
    }

    // ✅ Fix: Add this method to resolve the error
    public int getCurrentAccessCount() {
        return activeUserCount.get();
    }
}
