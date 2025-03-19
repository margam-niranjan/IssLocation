package com.example.issLocation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @GetMapping("/")
    public String redirectToIss() {
        return "redirect:/iss";
    }

    @RequestMapping(value = "/{path:[^\\.]*}")  // Ensures unknown paths redirect
    public String redirectUnknownPaths() {
        return "redirect:/iss";
    }
}
