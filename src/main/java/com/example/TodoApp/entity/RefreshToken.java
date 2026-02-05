//package com.example.TodoApp.entity;
//
//import jakarta.persistence.*;
//
//import java.time.Instant;
//
//@Entity
//@Table(name = "refresh_token")
//public class RefreshToken {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String token;
//
//    @Column(nullable = false)
//    private Instant expiresAt;
//
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//
//    //getter setter
//
//
//    public String getToken() {
//        return token;
//    }
//    public void setToken(String token) {
//        this.token = token;
//    }
//    public Instant getExpiresAt() {
//        return expiresAt;
//    }
//    public void setExpiresAt(Instant expiresAt) {
//        this.expiresAt = expiresAt;
//    }
//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
