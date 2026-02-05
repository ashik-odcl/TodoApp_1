package com.example.TodoApp.dto;

public class RegisterResponseDto {
    private Long id;
    private String role;
    private String username;

    public RegisterResponseDto(String username, String role, Long id) {
        this.id = id;
        this.role = role;
        this.username = username;
    }
    //getter setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}
