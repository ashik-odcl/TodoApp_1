package com.example.TodoApp.service;

import com.example.TodoApp.dto.RegisterRequestDto;
import com.example.TodoApp.dto.RegisterResponseDto;
import com.example.TodoApp.entity.Role;
import com.example.TodoApp.entity.User;
import com.example.TodoApp.repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponseDto register(@NonNull RegisterRequestDto registerRequestDto) {
        if(userRepository.existsByUsername(registerRequestDto.getUsername())) {
            throw new RuntimeException("Username is already in use");
        }
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        user.setRole(Role.ROLE_USER);
        User savedUser = userRepository.save(user);
        return new RegisterResponseDto(
                savedUser.getUsername(),
                savedUser.getRole().name(),
                savedUser.getId()
        );
    }
}
