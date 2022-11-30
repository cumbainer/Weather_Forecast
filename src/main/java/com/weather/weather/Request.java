package com.weather.weather;

import io.netty.handler.codec.http.HttpMethod;
import lombok.*;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


//ToDO refactor later

@Component
//https://api.weatherbit.io/v2.0/history/daily?city=Kyiv&country=Ukraine&start_date=2022-11-20&end_date=2022-11-27&key=730be0b5fcab45aa9e9606ca38a6c281
public class Request {
    private final String API_KEY = "730be0b5fcab45aa9e9606ca38a6c281";

    private final HttpClient httpClient = HttpClient.newHttpClient();


    //ToDo make method of building URL with param (daily, hourly, historical etc)

    //type is type of request (daily, hourly, historical etc)
    @SneakyThrows
    public String sendDayRequest(String city, String start_date, String end_date, String type)  {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.weatherbit.io/v2.0/forecast/daily?city="+city+"&country=Ukraine&start_date="
                        + start_date+"&end_date=" +end_date+"&key=" + this.API_KEY))
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
    @SneakyThrows
    public String sendHourRequest(String city, Integer hours)  {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.weatherbit.io/v2.0/forecast/hourly?city="+city+
                        "&country=Ukraine&lang=uk&hours="+hours+"&key="+this.API_KEY))
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }




}
