package com.weather.weather.service;

import com.weather.weather.repo.UserRepo;
import com.weather.weather.security.SecurityUser;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//No Arg con requeired for working properly
@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findUserByUsername(username);


        return user.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("user" + username + "not found"));
    }
}
