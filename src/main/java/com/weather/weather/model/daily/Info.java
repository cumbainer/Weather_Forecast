package com.weather.weather.model.daily;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@ToString
public class Info {

    private String city_name;
    private String country_code;
    private List<Weather> data;
    private String timezone;


}
