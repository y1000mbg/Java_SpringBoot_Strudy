package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.AddCalculator;
import com.example.app.Calculator;

// JavaConfigファイルのクラスであることを指定する
@Configuration

public class AppConfig {
	// Diコンテナでに管理させたい@Beanアノテーション
	@Bean
	Calculator calculator() {
		return new AddCalculator();
	}
}
