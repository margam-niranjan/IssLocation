package com.example.issLocation;

import com.example.issLocation.apiResponse.UserInfo;
import com.example.issLocation.service.UserTrackingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTrackingServiceTest {

    private UserTrackingService userTrackingService;
    private HttpServletRequest request;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        userTrackingService = new UserTrackingService(); // Initialize the real object, not a mock
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
         // Reset the list before each test
    }

    @Test
    void testTrackUser() {
        // Simulate mock behavior
        when(request.getRemoteAddr()).thenReturn("192.168.1.1");
        when(session.getId()).thenReturn("session123");

        // Call the method to track a user
        userTrackingService.trackUser(request, session, "Laptop", "Mozilla/5.0");

        // Get the list of users and verify the result
        List<UserInfo> users = userTrackingService.getUsers();
        assertEquals(1, users.size());

        UserInfo user = users.get(0);
        assertEquals("192.168.1.1", user.getIpAddress());
        assertEquals("session123", user.getSessionId());
        assertEquals("Laptop", user.getDeviceName());
        assertEquals("Mozilla/5.0", user.getBrowserInfo());
    }

    @Test
    void testTrackMultipleUsers() {
        // Simulate mock behavior for first user
        when(request.getRemoteAddr()).thenReturn("192.168.1.2");
        when(session.getId()).thenReturn("session456");

        userTrackingService.trackUser(request, session, "Mobile", "Safari");

        // Simulate mock behavior for second user
        when(request.getRemoteAddr()).thenReturn("192.168.1.3");
        when(session.getId()).thenReturn("session789");

        userTrackingService.trackUser(request, session, "Tablet", "Chrome");

        // Get the list of users and verify the result
        List<UserInfo> users = userTrackingService.getUsers();
        assertEquals(2, users.size());
    }
}
