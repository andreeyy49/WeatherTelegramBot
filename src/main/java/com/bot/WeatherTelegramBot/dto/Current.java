package com.bot.WeatherTelegramBot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Current {
    double temp_c;
    double temp_f;
    Condition condition;
    double wind_kph;
    int humidity;
    double feelslike_c;
}
