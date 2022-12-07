package com.weather.weather.controller;

import com.weather.weather.json.daily.Info;
import com.weather.weather.json.hourly.HourlyInfo;
import com.weather.weather.json.hourly.HourlyWeather;
import com.weather.weather.service.JsonPlaceholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class MainController {
    JsonPlaceholderService json;

    @Autowired
    public MainController(JsonPlaceholderService json) {
        this.json = json;
    }


    @GetMapping("/d/{city_name}")

    @PreAuthorize("hasRole('ROLE_ADIMN') or hasAnyRole('ROLE_ADMIN')")
    public String getDayWeather(@PathVariable("city_name") String city_name,
                             Model model)  {
        Info info = json.getWeather(city_name);

      //  HourlyInfo hour = json.getHourlyWeather(city_name);
        model.addAttribute("day", info);


        //ToDO add function to html page to every day of a week. Example if (Monday - list.get(1), Tuesday - list.get(2)
        model.addAttribute("hour", json.getHourlyWeather(city_name));


        return "weather";
    }


    @GetMapping("/h/{city_name}/{datetime}")
  //  @PreAuthorize("hasRole('admin')")
    public String getHourWeather(@PathVariable("city_name") String city_name, @PathVariable("datetime") String date,    //ToDo fix hourly weather later
                             Model model)  {
        HourlyInfo hour = json.getHourlyWeather(city_name);

        model.addAttribute("hour", hour);

        return "weather-hour";
    }


}
