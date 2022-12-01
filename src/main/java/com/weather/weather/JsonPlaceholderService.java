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
import java.util.regex.Pattern;

@Service
public class JsonPlaceholderService {

    private Request request;
    private final Gson gson = new Gson();
    Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}:(\\d{2})");
    private final String start_date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    private final String end_date = LocalDateTime.now().plusHours(1).format(DateTimeFormatter.ISO_DATE);


    @Autowired
    public JsonPlaceholderService(Request request) {
        this.request = request;
    }

    public Info getWeather(String city_name){
        return gson.fromJson(request.sendDayRequest(city_name, 7), Info.class);
    }

    public HourlyInfo getHourlyWeather(String city_name){


        return gson.fromJson(request.sendHourRequest(city_name,24), HourlyInfo.class);
    }







}
