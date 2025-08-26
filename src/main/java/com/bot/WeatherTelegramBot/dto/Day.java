package com.bot.WeatherTelegramBot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
    private double maxtemp_c;
    private double mintemp_c;
    private Condition condition;
}