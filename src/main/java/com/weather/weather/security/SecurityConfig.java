package com.weather.weather.security;


import com.weather.weather.repo.UserRepo;
import com.weather.weather.service.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//Auth provider class
@Configuration

public class SecurityConfig {
    //We dong have userDetailsService method because we have @Service on CustomUserDetailsService class

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



}
