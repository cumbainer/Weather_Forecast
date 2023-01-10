package com.weather.weather.service.impl;

import com.weather.weather.entity.Role;
import com.weather.weather.entity.User;
import com.weather.weather.exception.NullEntityReferenceException;
import com.weather.weather.repo.UserRepo;
import com.weather.weather.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    public User create(User user) {
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(Role.USER);
            return userRepo.save(user);
        }
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    public User readById(long id) {
        log.info("READ BY ID iS CALLED: " + userRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found")));
        return userRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));

    }

    public void delete(long id) {
        userRepo.delete(readById(id));
        log.info("USER DELETED WITH ID: " + id);
    }


    public List<User> getAll() {
        List<User> users = userRepo.findAll();
        log.info("GET ALL IS CALLED: "  + userRepo.findAll());
        return users.isEmpty() ? new ArrayList<>() : users;
    }
}
