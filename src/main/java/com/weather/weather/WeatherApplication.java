package com.weather.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
 * Made by @cumbainer (Vlad Shtaiier)
 */


@SpringBootApplication
public class WeatherApplication {
    public static void main(String[] args)  {

       SpringApplication.run(WeatherApplication.class, args);
    }


}
