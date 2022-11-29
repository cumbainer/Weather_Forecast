package com.weather.weather;

import com.google.gson.Gson;
import com.weather.weather.model.Info;
import com.weather.weather.model.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WeatherApplication {




    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        Request request = new Request();
        Gson gson = new Gson();
        String r = request.sendDayRequest("Kyiv", "2022-11-29", "2022-11-30");
        Info info = gson.fromJson(r, Info.class);
        System.out.println(r);

       SpringApplication.run(WeatherApplication.class, args);
    }


}
