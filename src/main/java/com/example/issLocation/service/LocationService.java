package com.example.issLocation.service;

import com.example.issLocation.apiResponse.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationService {
    private final RestTemplate restTemplate;

    @Autowired
    public LocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Response getIssLocation(){
        String apiUrl = "https://api.wheretheiss.at/v1/satellites/25544";
        return restTemplate.getForObject(apiUrl, Response.class);
    }
}
