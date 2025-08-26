package com.bot.WeatherTelegramBot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Location {
    String name;
    String region;
    String country;
    double lat;
    double lon;
    String tz_id;
    String localtime;
}
