package com.weather.weather.service;

import com.google.gson.Gson;
import com.weather.weather.json.daily.Info;
import com.weather.weather.json.hourly.HourlyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JsonPlaceholderService {
    private WeatherClientService request;
    private final Gson gson = new Gson();


    @Autowired
    public JsonPlaceholderService(WeatherClientService request) {
        this.request = request;
    }

    public Info getWeather(String city_name){
        return gson.fromJson(request.sendDayRequest(city_name, "7"), Info.class);
    }

    public HourlyInfo getHourlyWeather(String city_name){


        return gson.fromJson(request.sendHourRequest(city_name, "168" +
                "" +
                ""), HourlyInfo.class);
    }

}
