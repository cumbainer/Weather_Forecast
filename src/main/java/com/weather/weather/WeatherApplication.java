package com.weather.weather;

import com.google.gson.Gson;
import com.weather.weather.model.hourly.HourlyInfo;
import com.weather.weather.service.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.net.URISyntaxException;

/*
 * Made by @cumbainer (Vlad Shtaiier)
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WeatherApplication {
    public static void main(String[] args)  {

       SpringApplication.run(WeatherApplication.class, args);
    }


}
