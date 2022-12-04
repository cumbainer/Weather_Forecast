package com.weather.weather.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//main Spring Security Config class
@Configuration
public class SecurityConfig {

    //no userDetailsService() method because we have annotation @Service ot the top of CustomUserDetailsService class
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
