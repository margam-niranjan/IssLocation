package com.example.issLocation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotsTxtController {

    @GetMapping("/robots.txt")
    @ResponseBody
    public String getRobotsTxt() {
        return """
                User-agent: *
                Disallow: /user-info
                Disallow: /admin
                Allow: /iss
                """;
    }
}