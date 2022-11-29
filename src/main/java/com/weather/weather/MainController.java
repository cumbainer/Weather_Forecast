package com.weather.weather;

import com.weather.weather.model.Info;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/weather")
public class MainController {
    JsonPlaceholderService json;

    @Autowired
    public MainController(JsonPlaceholderService json) {
        this.json = json;
    }


    @GetMapping("/{city_name}")
    public String getWeather(@PathVariable("city_name") String city_name, Model model)  {
        Info info = json.getWeather(city_name);
        model.addAttribute("w", info);

        return "weather";
    }
}
