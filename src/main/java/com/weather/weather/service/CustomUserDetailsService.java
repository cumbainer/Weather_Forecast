package com.weather.weather.service;

import com.weather.weather.repo.UserRepo;
import com.weather.weather.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public SecurityUser loadUserByUsername(String username) {
        var u = userRepo.findUserByUsername(username);
        return u.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
    }


}
