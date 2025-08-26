package com.bot.WeatherTelegramBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherTelegramBotApplication.class, args);
	}

}
