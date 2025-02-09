package com.example.issLocation.controller;

import com.example.issLocation.apiResponse.UserInfo;
import com.example.issLocation.service.UserTrackingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user-info")
public class UserInfoController {
    private final UserTrackingService trackingService;

    public UserInfoController(UserTrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping
    public String getUsers(Model model) {
        List<UserInfo> users = trackingService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("userCount", users.size()); // ✅ Add user count
        return "user-info"; // ✅ Returns `user-info.html`
    }
}
