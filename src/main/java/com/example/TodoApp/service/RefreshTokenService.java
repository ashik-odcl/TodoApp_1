//package com.example.TodoApp.service;
//
//import com.example.TodoApp.entity.RefreshToken;
//import com.example.TodoApp.entity.User;
//import com.example.TodoApp.repository.RefreshTokenRepository;
//import org.jspecify.annotations.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class RefreshTokenService {
//    @Value("${app.jwt.refresh-expiration}")
//    private Long refreshTokenDuration;
//
//    public final RefreshTokenRepository refreshTokenRepository;
//    @Autowired
//    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
//        this.refreshTokenRepository = refreshTokenRepository;
//    }
//
//    public RefreshToken createRefreshToken(User user) {
//        RefreshToken token = new RefreshToken();
//        token.setUser(user);
//        token.setToken(UUID.randomUUID().toString());
//        token.setExpiresAt(Instant.now().plusMillis(refreshTokenDuration));
//        return refreshTokenRepository.save(token);
//    }
//
//    public RefreshToken verifyRefreshToken(@NonNull RefreshToken token) {
//        if(token.getExpiresAt().isBefore(Instant.now())) {
//            refreshTokenRepository.delete(token);
//            throw new RuntimeException("Token Expired");
//        }
//        return token;
//    }
//
//    public void deleteByUser(User user) {
//        refreshTokenRepository.deleteByUser(user);
//    }
//}
