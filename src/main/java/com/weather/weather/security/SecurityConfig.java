package com.weather.weather.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//Auth provider class
@Configuration



@EnableMethodSecurity
public class SecurityConfig {
    //We dong have userDetailsService method because we have @Service on CustomUserDetailsService class

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.csrf().disable()
                    .authorizeHttpRequests().requestMatchers("/create").permitAll()
                    .and()

                .authorizeHttpRequests()

                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login").permitAll()
           //      .loginProcessingUrl("/weather-hour")
                    .defaultSuccessUrl("/home", true);
        ;



            return http.build();


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



//    @Bean
//    public WebSecurityCustomizer ignoreResources() {
//        return (webSecurity) -> webSecurity
//                .ignoring()
//                .requestMatchers("/d/*");  //ToDo change later to valid page
//
//    }
//








}
