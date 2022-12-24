package com.weather.weather.service;

import com.google.gson.Gson;
import com.weather.weather.json.daily.Info;
import com.weather.weather.json.hourly.HourlyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JsonPlaceholderService {
    private Client request;
    private final Gson gson = new Gson();





    //ToDo add possibility to see date in url using @PathVariable, example (../Kiev/2022-12-02)
    @Autowired
    public JsonPlaceholderService(Client request) {
        this.request = request;
    }

    public Info getWeather(String city_name){
        return gson.fromJson(request.sendDayRequest(city_name, "7"), Info.class);
        //returns null because we need to add MongoDb and take info from db later
        //Or hash DB, but for sure not from this
    }

    public HourlyInfo getHourlyWeather(String city_name){


        return gson.fromJson(request.sendHourRequest(city_name, "24"), HourlyInfo.class);
    }
//    public void getHourlyWeather(String city_name){
//
//
//       gson.fromJson(request.sendHourRequest(city_name,24), HourlyInfo.class);
//    }
    //replace after for

}
