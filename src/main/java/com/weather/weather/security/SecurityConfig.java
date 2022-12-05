package com.weather.weather.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Auth provider class
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //We dong have userDetailsService method because we have @Service on CustomUserDetailsSe


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf().disable()
             //  .authorizeHttpRequests().anyRequest().authenticated()
                .authorizeHttpRequests().requestMatchers("/{city_name}").permitAll()
                .and().authorizeHttpRequests().requestMatchers("/{city_name}/{datetime}").authenticated()
                .and().build();

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }




}
