package com.weather.weather;

import com.google.gson.Gson;
import com.weather.weather.model.daily.Info;
import com.weather.weather.model.hourly.HourlyInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WeatherApplication {




    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
//        Request request = new Request();
//        Gson gson = new Gson();
//        String r = request.sendDayRequest("Kyiv", "2022-11-29", "2022-11-30", "daily");
//        HourlyInfo info = gson.fromJson(r, HourlyInfo.class);
//        System.out.println(info.getData().get(1).getDatetime().substring(8, 10));




       SpringApplication.run(WeatherApplication.class, args);
    }


}
