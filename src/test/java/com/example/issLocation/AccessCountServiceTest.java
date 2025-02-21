package com.example.issLocation;
import com.example.issLocation.service.AccessCountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccessCountServiceTest {

    private AccessCountService accessCountService;

    @BeforeEach
    void setUp() {
        accessCountService = new AccessCountService();
    }

    @Test
    void testIncrementAccessCount() {
        assertEquals(0, accessCountService.getAccessCount());

        accessCountService.incrementAccessCount();
        assertEquals(1, accessCountService.getAccessCount());

        accessCountService.incrementAccessCount();
        assertEquals(2, accessCountService.getAccessCount());
    }

    @Test
    void testDecrementAccessCount() {
        accessCountService.incrementAccessCount();
        accessCountService.incrementAccessCount();
        assertEquals(2, accessCountService.getAccessCount());

        accessCountService.decrementAccessCount();
        assertEquals(1, accessCountService.getAccessCount());

        accessCountService.decrementAccessCount();
        assertEquals(0, accessCountService.getAccessCount());
    }

    @Test
    void testDecrementAccessCount_BelowZero() {
        assertEquals(0, accessCountService.getAccessCount());

        accessCountService.decrementAccessCount();
        assertEquals(0, accessCountService.getAccessCount());
    }

    @Test
    void testGetAccessCount() {
        assertEquals(0, accessCountService.getAccessCount());

        accessCountService.incrementAccessCount();
        assertEquals(1, accessCountService.getAccessCount());

        accessCountService.decrementAccessCount();
        assertEquals(0, accessCountService.getAccessCount());
    }
}