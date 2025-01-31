package com.example.issLocation.controller;

import com.example.issLocation.apiResponse.Response;
import com.example.issLocation.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/iss")
    public Map<String, Double> getISSLocation() {
        Response response = locationService.getIssLocation();

        double latitude = Double.parseDouble(response.getLatitude().toString());
        double longitude = Double.parseDouble(response.getLongitude().toString());

        Map<String, Double> location = new HashMap<>();
        location.put("latitude", latitude);
        location.put("longitude", longitude);

        return location;
    }
}
