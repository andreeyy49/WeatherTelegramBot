package com.bot.WeatherTelegramBot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Condition {
    String text;
    String icon;
}
