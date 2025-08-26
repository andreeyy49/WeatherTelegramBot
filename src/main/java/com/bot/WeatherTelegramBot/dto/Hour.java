package com.bot.WeatherTelegramBot.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hour {
    private String time;
    private double temp_c;
    private Condition condition;
}