//package com.example.TodoApp.controller;
//
//import com.example.TodoApp.dto.LogInRequestDto;
////import com.example.TodoApp.dto.RefreshRequestDto;
////import com.example.TodoApp.dto.RefreshResponseDto;
////import com.example.TodoApp.entity.RefreshToken;
//import com.example.TodoApp.entity.User;
////import com.example.TodoApp.repository.RefreshTokenRepository;
//import com.example.TodoApp.repository.UserRepository;
//import com.example.TodoApp.security.JwtUtil;
////import com.example.TodoApp.service.RefreshTokenService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController__RefreshToken {
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//    private JwtUtil jwtUtil;
////    private RefreshTokenService refreshTokenService;
////    private RefreshTokenRepository refreshTokenRepository;
//
//
//    public AuthController__RefreshToken(
//            UserRepository userRepository,
//            PasswordEncoder passwordEncoder,
//            JwtUtil jwtUtil
////            RefreshTokenService refreshTokenService,
////            RefreshTokenRepository refreshTokenRepository
//    ) {
//        this.userRepository=userRepository;
//        this.passwordEncoder=passwordEncoder;
//        this.jwtUtil=jwtUtil;
////        this.refreshTokenService = refreshTokenService;
////        this.refreshTokenRepository=refreshTokenRepository;
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody LogInRequestDto dto){
//        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(()-> new RuntimeException("Username not found"));
//        String accessToken = jwtUtil.generateToken(user.getUsername());
//        //RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
//        //RefreshResponseDto response = new RefreshResponseDto();
//        //response.setAccessToken(accessToken);
//        //response.setRefreshToken(refreshToken.getToken());
//        if(!passwordEncoder.matches(dto.getPassword(),user.getPassword())){
//            throw new RuntimeException("Invalid password");
//        }
//        //return response.toString();
//        return accessToken;
//    }
//
////    @PostMapping("/refresh")
////    public RefreshResponseDto refreshToken(
////            @RequestBody RefreshRequestDto request) {
////
////        RefreshToken refreshToken =
////                refreshTokenRepository
////                        .findByToken(request.getRefreshToken())
////                        .map(refreshTokenService::verifyRefreshToken)
////                        .orElseThrow(() ->
////                                new RuntimeException("Invalid refresh token"));
////
////        User user = refreshToken.getUser();
////        String newAccessToken = jwtUtil.generateToken(user.getUsername());
////
////        RefreshResponseDto response = new RefreshResponseDto();
////        response.setAccessToken(newAccessToken);
////        response.setRefreshToken(refreshToken.getToken());
////
////        return response;
////    }
//
////    private User getCurrentUser(){
////        SecurityUtil securityUtil = new SecurityUtil();
////        String username = securityUtil.getCurrentUsername();
////        return userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("Username not found"));
////    }
//
////    @PostMapping("/logout")
////    public void logout() {
////
////        User user = getCurrentUser();
////        refreshTokenService.deleteByUser(user);
////    }
//
//
//
//}
