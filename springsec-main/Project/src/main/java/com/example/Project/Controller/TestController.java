package com.example.Project.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String allAccess() {
        return "Public Content.";
    }
    @GetMapping("/mod")
    @PreAuthorize("hasRole('ROLE_RC')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}
