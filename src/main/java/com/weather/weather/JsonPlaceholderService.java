package com.weather.weather;

import com.google.gson.Gson;
import com.weather.weather.model.daily.Info;
import com.weather.weather.model.hourly.HourlyInfo;
import com.weather.weather.model.hourly.HourlyWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JsonPlaceholderService {

    private Request request;
    private final Gson gson = new Gson();
    private final String start_date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    private final String end_date = LocalDateTime.now().plusHours(24).format(DateTimeFormatter.ISO_DATE);


    @Autowired
    public JsonPlaceholderService(Request request) {
        this.request = request;
    }

    public Info getWeather(String city_name){
        return gson.fromJson(request.sendDayRequest(city_name, start_date, end_date, "daily"), Info.class);
    }

    public HourlyInfo getHourlyWeather(String city_name){



        return gson.fromJson(request.sendDayRequest(city_name, start_date, end_date, "hourly"), HourlyInfo.class);
    }





}
