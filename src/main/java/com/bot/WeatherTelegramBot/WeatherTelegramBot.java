package com.bot.WeatherTelegramBot;

import com.bot.WeatherTelegramBot.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.WebhookBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@RequiredArgsConstructor
public class WeatherTelegramBot implements WebhookBot {
    @Value("${telegram.bot.username}")
    private String botUsername;
    @Value("${telegram.bot.key}")
    private String botToken;
    @Value("${telegram.bot.path}")
    private String botPath;
    @Value("${spring.application.url}")
    private String appUrl;
    private final WeatherService weatherService;
    private final WeatherSender weatherSender;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasLocation()) {
            String chatId = update.getMessage().getChatId().toString();
            double lat = update.getMessage().getLocation().getLatitude();
            double lon = update.getMessage().getLocation().getLongitude();

            String weatherInfo = weatherService.getCurrentWeather(lat + "," + lon);

            weatherSender.sendTextMessage(chatId, weatherInfo);
        }
        return null;
    }


    @Override
    public void setWebhook(SetWebhook setWebhook) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this, SetWebhook.builder()
                .url(appUrl)
                .build());
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
