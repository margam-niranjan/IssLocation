package com.example.issLocation.userTrack;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private final ActiveUserTracker activeUserTracker;

    public SessionListener(ActiveUserTracker activeUserTracker) {
        this.activeUserTracker = activeUserTracker;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeUserTracker.userLoggedIn(se.getSession());
        System.out.println("User logged in. Active users: " + activeUserTracker.getActiveUserCount());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeUserTracker.userLoggedOut(se.getSession());
        System.out.println("User logged out. Active users: " + activeUserTracker.getActiveUserCount());
    }
}
