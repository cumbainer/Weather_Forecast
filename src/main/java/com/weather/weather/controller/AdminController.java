package com.weather.weather.controller;


import com.weather.weather.entity.User;
import com.weather.weather.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private UserRepo userRepo;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
