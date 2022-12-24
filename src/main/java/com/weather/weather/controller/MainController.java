package com.weather.weather.controller;

import com.weather.weather.entity.Role;
import com.weather.weather.entity.User;
import com.weather.weather.json.daily.Info;
import com.weather.weather.json.hourly.HourlyInfo;
import com.weather.weather.json.hourly.HourlyWeather;
import com.weather.weather.service.JsonPlaceholderService;
import com.weather.weather.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@AllArgsConstructor
public class MainController {
    JsonPlaceholderService json;
    UserService userService;



    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("roles",  Role.values());
        return "create-user";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "create-user";
        }
        user.setPassword(user.getPassword());
        user.setRole(Role.USER);
        //make role later
        userService.create(user);
        return "redirect:/d/Kyiv";
    }


    @GetMapping("/d/{city_name}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String getDayWeather(@PathVariable("city_name") String city_name,
                             Model model)  {
        Info info = json.getWeather(city_name);

      //  HourlyInfo hour = json.getHourlyWeather(city_name);
        model.addAttribute("day", info);


        //ToDO add function to html page to every day of a week. Example if (Monday - list.get(1), Tuesday - list.get(2)
        model.addAttribute("hour", json.getHourlyWeather(city_name));


        return "weather";
    }

                                                            
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{city_name}/{datetime}")
    public String getHourWeather(@PathVariable("city_name") String city_name, @PathVariable("datetime") String date,    //ToDo fix hourly weather later
                             Model model)  {
        HourlyInfo hour = json.getHourlyWeather(city_name);

        model.addAttribute("hour", hour);

        return "weather-hour";
    }

    @GetMapping("/login")
    public String login (){
        return "login";
    }




}
