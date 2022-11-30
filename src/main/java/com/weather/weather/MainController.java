package com.weather.weather;

import com.weather.weather.model.daily.Info;
import com.weather.weather.model.hourly.HourlyInfo;
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
    public String getWeather(@PathVariable("city_name") String city_name, Model model)  {
        Info info = json.getWeather(city_name);
        HourlyInfo hour = json.getHourlyWeather(city_name);
        model.addAttribute("w", info);
        //ToDO add images
        model.addAttribute("hour", hour.getData());

        return "weather";
    }


}
