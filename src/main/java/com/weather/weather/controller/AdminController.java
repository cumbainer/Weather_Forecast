package com.weather.weather.controller;


import com.weather.weather.entity.User;
import com.weather.weather.repo.UserRepo;
import com.weather.weather.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or authentication.principal.id == #id")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
