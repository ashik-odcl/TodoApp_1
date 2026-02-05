package com.example.TodoApp.controller;

import com.example.TodoApp.dto.LogInRequestDto;
import com.example.TodoApp.dto.RegisterRequestDto;
import com.example.TodoApp.dto.RegisterResponseDto;
import com.example.TodoApp.entity.User;
import com.example.TodoApp.repository.UserRepository;
import com.example.TodoApp.security.JwtUtil;
import com.example.TodoApp.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthService authService;


    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil,
            AuthService authService
    ) {
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
        this.authService=authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LogInRequestDto dto){
        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(()-> new RuntimeException("Username not found"));
        String accessToken = jwtUtil.generateToken(user.getUsername());
        if(!passwordEncoder.matches(dto.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return accessToken;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(
            @Valid @RequestBody RegisterRequestDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.register(dto));
    }

}
