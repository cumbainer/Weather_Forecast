package com.weather.weather.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


//ToDO refactor later

@Component
public class Client {
    private final String API_KEY = getAPI_KEY();

    private final HttpClient httpClient = HttpClient.newHttpClient();


    //method of generating url and getting response via daily weather
    @SneakyThrows
    public String sendDayRequest(String city, String days) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.weatherbit.io/v2.0/forecast/daily?city=" + city + "&country=Ukraine&days=" + days + "&key=" + this.API_KEY))
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    //method of generating url and getting response via hourly weather
    @SneakyThrows
    public String sendHourRequest(String city, String hours) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.weatherbit.io/v2.0/forecast/hourly?city=" + city +
                        "&country=Ukraine&lang=uk&hours=" + hours + "&key=" + this.API_KEY))
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }


    //method to hide apikey
    @SneakyThrows
    private String getAPI_KEY(){
        File file = new File(
                "D:\\java prog/APIKEY_WEATHER_2.txt");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        return br.readLine();
    }


}
