package com.bot.WeatherTelegramBot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Getter
public class Location {
    String name;
    String country;
    String localtime;
}
