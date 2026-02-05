package com.example.TodoApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.NonNull;

public class RegisterRequestDto {
    @NotBlank
    @Size(min = 4, max = 32)
    private String username;
    @NotBlank
    @Size(min = 4, max = 32)
    private String password;


    /// getter setter
    public  String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
