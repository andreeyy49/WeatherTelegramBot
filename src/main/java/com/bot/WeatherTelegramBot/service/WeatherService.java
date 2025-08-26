package com.bot.WeatherTelegramBot.service;

import com.bot.WeatherTelegramBot.client.WeatherApiClient;
import com.bot.WeatherTelegramBot.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

    private final WeatherApiClient weatherApiClient;
    @Value("${weather.api.key}")
    private String weatherKey;

    public String getCurrentWeather(String latLon) {
        WeatherResponse response = weatherApiClient.getWeather(weatherKey, latLon);
        log.info(response.toString());
        return String.valueOf(response.getCurrent().getTemp_c());
    }
}
