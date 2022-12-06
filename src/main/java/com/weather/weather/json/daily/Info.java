package com.weather.weather.json.daily;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@ToString
public class Info {

    private String city_name;
    private String country_code;
    private List<Weather> data = new ArrayList<>();
    private String timezone;


}
