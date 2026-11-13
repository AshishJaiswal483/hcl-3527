package com.abes.employeeapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




//BCrypt: A one-way password hashing algorithm.
//
//encode(): Converts a raw password into a secure hash.
//
//matches(): Checks a raw password against its stored hash.

//example
//passwordEncoder.encode("admin123");
//passwordEncoder.matches("admin123", hashedPassword);
