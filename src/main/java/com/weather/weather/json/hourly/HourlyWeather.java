package com.weather.weather.json.hourly;

import lombok.Data;

@Data
public class HourlyWeather {

    private double app_temp;
    private double temp;
    private double wind_spd;

    private String datetime;
    HourlyWeatherDescription weather;



}
