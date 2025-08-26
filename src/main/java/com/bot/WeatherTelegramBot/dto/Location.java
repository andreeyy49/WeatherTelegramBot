package com.bot.WeatherTelegramBot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
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
