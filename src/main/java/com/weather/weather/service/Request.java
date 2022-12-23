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
//https://api.weatherbit.io/v2.0/forecast/daily?city=Kyiv&country=Ukraine&days=3&key=730be0b5fcab45aa9e9606ca38a6c281
public class Request {
    private final String API_KEY = getAPI_KEY();

    private final HttpClient httpClient = HttpClient.newHttpClient();


    //ToDo make method of building URL with param (daily, hourly, historical etc)

    //type is type of request (daily, hourly, historical etc)
    @SneakyThrows
    public String sendDayRequest(String city, String days) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.weatherbit.io/v2.0/forecast/daily?city=" + city + "&country=Ukraine&days=" + days + "&key=" + this.API_KEY))
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    @SneakyThrows
    public String sendHourRequest(String city, String hours) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.weatherbit.io/v2.0/forecast/hourly?city=" + city +
                        "&country=Ukraine&lang=uk&hours=" + hours + "&key=" + this.API_KEY))
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    @SneakyThrows
    private String getAPI_KEY(){
        File file = new File(
                "D:\\java prog/APIKEY_WEATHER_2.txt");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        String out = br.readLine();

        return out;
    }


}
