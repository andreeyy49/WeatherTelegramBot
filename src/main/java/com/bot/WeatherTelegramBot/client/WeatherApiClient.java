package com.bot.WeatherTelegramBot.client;

import com.bot.WeatherTelegramBot.dto.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherApiClient", url = "${weather.api.url}")
public interface WeatherApiClient {

    @GetMapping("/current.json")
    WeatherResponse getWeather(@RequestParam("key") String weatherKey,
                               @RequestParam("q") String latLon);
}