package com.bot.WeatherTelegramBot.service;

import com.bot.WeatherTelegramBot.client.WeatherApiClient;
import com.bot.WeatherTelegramBot.dto.Hour;
import com.bot.WeatherTelegramBot.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

    private final WeatherApiClient weatherApiClient;
    @Value("${weather.api.key}")
    private String weatherKey;

    public String getCurrentWeather(String latLon) {
        WeatherResponse response = weatherApiClient.getCurrentWeather(weatherKey, latLon);
        log.info(response.toString());
        return response.getCurrent().getTemp_c()
                + "° ощущается как "
                + response.getCurrent().getFeelslike_c()
                + "° "
                + response.getCurrent().getCondition().getText()
                + " ёптыть";
    }

    public String getForecastWeather(String latLon) {
        WeatherResponse response = weatherApiClient.getForecastWeather(weatherKey, latLon, 1);
        log.info(response.toString());
        List<Hour> hours = response.getForecast().getForecastday().getFirst().getHour();
        List<Hour> every3Hour = IntStream.range(0, hours.size())
                .filter(i -> i % 3 == 0)
                .mapToObj(hours::get)
                .toList();

        StringBuilder builder = new StringBuilder();

        for (Hour hour : every3Hour) {
            builder.append(hour.getTime())
                    .append(" ")
                    .append(hour.getTemp_c())
                    .append(" - ")
                    .append(hour.getCondition().getText())
                    .append("\n");
        }

        return builder.toString();
    }
}
