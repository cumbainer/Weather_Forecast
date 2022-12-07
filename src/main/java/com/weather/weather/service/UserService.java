package com.weather.weather.service;

import com.weather.weather.entity.User;
import com.weather.weather.exception.NullEntityReferenceException;
import com.weather.weather.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    public User create(User user) {
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
        throw new NullEntityReferenceException("User cannot be 'null'");
    }
}
