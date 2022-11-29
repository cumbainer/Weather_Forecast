package com.weather.weather.model.hourly;

import lombok.Data;

import java.util.List;

@Data
public class HourlyInfo {

    private String city_name;
    private String timezone;
    private List<HourlyWeather> data;

}
