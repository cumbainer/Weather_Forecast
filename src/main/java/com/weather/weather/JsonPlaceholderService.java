package com.weather.weather;

import com.google.gson.Gson;
import com.weather.weather.model.Info;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class JsonPlaceholderService {

    private Request request;
    private final Gson gson = new Gson();
    private final String start_date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    private final String end_date = LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ISO_DATE);


    @Autowired
    public JsonPlaceholderService(Request request) {
        this.request = request;
    }

    public Info getWeather(String city_name){
        return gson.fromJson(request.sendDayRequest(city_name, start_date, end_date), Info.class);

    }



}
