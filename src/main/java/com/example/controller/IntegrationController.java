package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IntegrationController {

    private final UserService userService;

    public IntegrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @PostMapping("/save")
    public String addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return "success";
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
