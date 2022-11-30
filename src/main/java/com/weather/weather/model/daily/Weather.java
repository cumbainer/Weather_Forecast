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
    DailyWeatherDescription weather;

}
