package com.weather.weather.controller;

import com.weather.weather.json.daily.Info;
import com.weather.weather.json.hourly.HourlyInfo;
import com.weather.weather.service.JsonPlaceholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MainController {
    JsonPlaceholderService json;

    @Autowired
    public MainController(JsonPlaceholderService json) {
        this.json = json;
    }


    @GetMapping("/{city_name}")
    public String getDayWeather(@PathVariable("city_name") String city_name,
                             Model model)  {
        Info info = json.getWeather(city_name);
        HourlyInfo hour = json.getHourlyWeather(city_name);
        model.addAttribute("day", info);


        //ToDO add function to html page to every day of a week. Example if (Monday - list.get(1), Tuesday - list.get(2)
        model.addAttribute("hour", hour.getData());


        return "weather";
    }


    @GetMapping("/{city_name}/{datetime}")
    public String getHourWeather(@PathVariable("city_name") String city_name, @PathVariable("datetime") String date,
                             Model model)  {
        HourlyInfo hour = json.getHourlyWeather(city_name);


        model.addAttribute("hour", hour);

        return "weather-hour";
    }



}
