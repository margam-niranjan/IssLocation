package com.example.issLocation.controller;

import com.example.issLocation.service.LocationService;
import com.example.issLocation.service.UserTrackingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
@CrossOrigin(origins = "*")
@Controller
public class LocationController {
    private final LocationService locationService;
    private final UserTrackingService userTrackingService;

    public LocationController(LocationService locationService, UserTrackingService userTrackingService) {
        this.locationService = locationService;
        this.userTrackingService = userTrackingService;
    }

    @GetMapping("/iss")
    public String getISSLocation(HttpServletRequest request, HttpSession session, Model model) {
        var response = locationService.getIssLocation();

        // Store latitude & longitude in Model for Thymeleaf
        model.addAttribute("latitude", response.getLatitude());
        model.addAttribute("longitude", response.getLongitude());

        // Track user
        String ipAddress = request.getRemoteAddr();
        String hostname;
        String deviceName = "Unknown";

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            hostname = inetAddress.getHostName();
            deviceName = hostname.contains(".") ? hostname.split("\\.")[0] : hostname;
        } catch (UnknownHostException e) {
            hostname = "Unknown";
        }

        userTrackingService.trackUser(request, session, deviceName, request.getHeader("User-Agent"));

        return "iss";
    }
}
