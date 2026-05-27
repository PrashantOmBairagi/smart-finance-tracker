package com.prashant.smartfinancetracker.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private  String username;

    private String password;

    private String email;

    private String firstName;
    private String lastName;
    private String phone;
    private LocalDateTime createdAt;
}
