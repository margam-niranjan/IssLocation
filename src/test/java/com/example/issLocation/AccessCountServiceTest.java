package com.example.issLocation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.issLocation.service.AccessCountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccessCountServiceTest {

    private AccessCountService accessCountService;

    @BeforeEach
    void setUp() {
        accessCountService = new AccessCountService();
    }

    @Test
    void testInitialAccessCountIsZero() {
        assertEquals(0, accessCountService.getCurrentAccessCount());
    }

    @Test
    void testIncrementAccessCount() {
        accessCountService.incrementAccessCount();
        assertEquals(1, accessCountService.getCurrentAccessCount());

        accessCountService.incrementAccessCount();
        assertEquals(2, accessCountService.getCurrentAccessCount());
    }

    @Test
    void testDecrementAccessCount() {
        accessCountService.incrementAccessCount();
        accessCountService.incrementAccessCount();
        assertEquals(2, accessCountService.getCurrentAccessCount());

        accessCountService.decrementAccessCount();
        assertEquals(1, accessCountService.getCurrentAccessCount());

        accessCountService.decrementAccessCount();
        assertEquals(0, accessCountService.getCurrentAccessCount());

        // Ensure count does not go negative
        accessCountService.decrementAccessCount();
        assertEquals(0, accessCountService.getCurrentAccessCount());
    }
}
