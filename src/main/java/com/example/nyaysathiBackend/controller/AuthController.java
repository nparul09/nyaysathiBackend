package com.example.nyaysathiBackend.controller;

import com.example.nyaysathiBackend.model.Role;
import com.example.nyaysathiBackend.security.JwtUtils;
import org.springframework.web.bind.annotation.*;
import com.example.nyaysathiBackend.repo.UserRepository;
import com.example.nyaysathiBackend.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthController(UserRepository repo, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public User register(@RequestBody Map<String,String> body) {
        String u = body.get("username");
        String p = body.get("password");
        String role = body.getOrDefault("role","CITIZEN");
        var user = new User(u, passwordEncoder.encode(p), Role.valueOf(role));
        return repo.save(user);
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> body) {
        String u = body.get("username");
        String p = body.get("password");
        User userOpt = repo.findByUsername(u);
        if (userOpt == null) throw new RuntimeException("Invalid credentials");
        if (!passwordEncoder.matches(p, userOpt.getPassword())) throw new RuntimeException("Invalid credentials");
        String token = jwtUtils.generateToken(userOpt.getUsername());
        return Map.of("token", token, "role", userOpt.getRole().name());
    }
}
