package com.bot.WeatherTelegramBot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {
    private String date;
    private Day day;
    private List<Hour> hour;
}