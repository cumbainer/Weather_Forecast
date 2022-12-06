package com.weather.weather.json.hourly;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HourlyInfo {

    private String city_name;
    private String timezone;
    private List<HourlyWeather> data = new ArrayList<>();

}
