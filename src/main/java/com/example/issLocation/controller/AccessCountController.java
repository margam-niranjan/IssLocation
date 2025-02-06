package com.example.issLocation.controller;

import com.example.issLocation.service.AccessCountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessCountController {

    private final AccessCountService accessCountService;

    public AccessCountController(AccessCountService accessCountService) {
        this.accessCountService = accessCountService;
    }

    @GetMapping("/active-users")
    public int getActiveUserCount() {
        return accessCountService.getAccessCount();
    }
}
