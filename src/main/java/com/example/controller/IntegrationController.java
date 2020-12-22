package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntegrationController {

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }
}
