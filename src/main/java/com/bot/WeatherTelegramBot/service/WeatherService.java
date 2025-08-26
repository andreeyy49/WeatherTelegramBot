package com.bot.WeatherTelegramBot.service;

import com.bot.WeatherTelegramBot.client.WeatherApiClient;
import com.bot.WeatherTelegramBot.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherApiClient weatherApiClient;
    @Value("${weather.api.key}")
    private String weatherKey;

    public String getCurrentWeather(String latLon) {
        WeatherResponse response = weatherApiClient.getWeather(weatherKey, latLon);
        return String.valueOf(response.getCurrent().getTemp_c());
    }
}
