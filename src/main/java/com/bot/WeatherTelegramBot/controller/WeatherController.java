package com.bot.WeatherTelegramBot.controller;

import com.bot.WeatherTelegramBot.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{latLon}")
    public String getWeather(@PathVariable String latLon) {
        return weatherService.getCurrentWeather(latLon);
    }
}