package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/who-am-i")
    public String whoAmI(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        model.addAttribute("authorities", SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
        model.addAttribute("credentials", SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
        model.addAttribute("details", SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
        return "who-am-i";
    }
}
