package com.bot.WeatherTelegramBot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WeatherResponse {
    Location location;
    Current current;
}
