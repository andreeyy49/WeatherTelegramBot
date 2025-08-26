package com.bot.WeatherTelegramBot.controller;

import com.bot.WeatherTelegramBot.WeatherTelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequiredArgsConstructor
public class WebhookController {

    private final WeatherTelegramBot weatherTelegramBot;

    @PostMapping("/telegram")
    public void receiveUpdate(@RequestBody Update update) {
        weatherTelegramBot.onWebhookUpdateReceived(update);
    }

}
