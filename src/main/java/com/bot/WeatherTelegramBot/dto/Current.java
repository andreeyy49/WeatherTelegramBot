package com.bot.WeatherTelegramBot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Current {
    double temp_c;
    Condition condition;
    double feelslike_c;
}
