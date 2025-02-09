package com.example.issLocation.service;

import com.example.issLocation.apiResponse.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserTrackingService {
    private final List<UserInfo> users = new ArrayList<>();

    public void trackUser(HttpServletRequest request, HttpSession session, String deviceName, String userAgent) {
        String ipAddress = request.getRemoteAddr();
        String hostname;

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            hostname = inetAddress.getHostName();
        } catch (UnknownHostException e) {
            hostname = "Unknown";
        }

        UserInfo user = new UserInfo(ipAddress, hostname, userAgent, session.getId(), deviceName); // ✅ Now matches 5-parameter constructor
        users.add(user);
    }

    public List<UserInfo> getUsers() {
        return users;
    }
}
