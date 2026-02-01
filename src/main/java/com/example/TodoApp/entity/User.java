package com.example.TodoApp.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "UserTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;



}
