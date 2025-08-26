package com.bot.WeatherTelegramBot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class WeatherSender extends DefaultAbsSender {

    private final String botToken;

    public WeatherSender(@Value("${telegram.bot.key}") String botToken) {
        super(new DefaultBotOptions());
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void sendTextMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message); // метод DefaultAbsSender
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendKeyboard(Long chatId) {
        InlineKeyboardButton todayBtn = InlineKeyboardButton.builder()
                .text("Прогноз на сегодня")
                .callbackData("forecast_today")
                .build();

        InlineKeyboardButton currentBtn = InlineKeyboardButton.builder()
                .text("Прогноз на сейчас")
                .callbackData("current")
                .build();

        InlineKeyboardMarkup markup = InlineKeyboardMarkup.builder()
                .keyboard(List.of(List.of(todayBtn, currentBtn)))
                .build();

        SendMessage message = SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text("Выберите прогноз:")
                .replyMarkup(markup)
                .build();

        try {
            this.execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
