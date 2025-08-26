package com.bot.WeatherTelegramBot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Current {
    double temp_c;
    double temp_f;
    Condition condition;
    double wind_kph;
    int humidity;
    double feelslike_c;
}
