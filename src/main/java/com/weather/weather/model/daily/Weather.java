package com.weather.weather.model.daily;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Weather {

    private String datetime;
    private double max_temp;
    private double min_temp;
    private double temp;
    private double app_max_temp;
    private double app_min_temp;
    private double feels_as = (app_max_temp + app_min_temp) /2;
    DailyWeatherDescription weather;

}
