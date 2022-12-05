package com.weather.weather.security;


import com.weather.weather.repo.UserRepo;
import com.weather.weather.service.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//Auth provider class
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //We dong have userDetailsService method because we have @Service on CustomUserDetailsService class


    @Override
    protected void configure(HttpSecurity http) throws Exception {


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



}
