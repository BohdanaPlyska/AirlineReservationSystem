package com.example.demo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main (String[] args) {
        BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        System.out.println("Password: " + password );
    }
}
