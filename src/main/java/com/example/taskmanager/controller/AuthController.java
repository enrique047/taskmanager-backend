package com.example.taskmanager.controller;

import com.example.taskmanager.dto.RegisterRequest;
import com.example.taskmanager.dto.LoginRequest;
import com.example.taskmanager.dto.LoginResponse;
import com.example.taskmanager.security.JwtUtil;
import com.example.taskmanager.service.UserService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(
            UserService userService,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        userService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Generate JWT after successful authentication
        String token = jwtUtil.generateToken(authentication.getName());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
