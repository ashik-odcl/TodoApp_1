package com.example.TodoApp.controller;

import com.example.TodoApp.dto.LogInRequestDto;
import com.example.TodoApp.entity.User;
import com.example.TodoApp.repository.UserRepository;
import com.example.TodoApp.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;


    public  AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LogInRequestDto dto){
        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(()-> new RuntimeException("Username not found"));
        if(passwordEncoder.matches(dto.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(user.getUsername());
    }

}
