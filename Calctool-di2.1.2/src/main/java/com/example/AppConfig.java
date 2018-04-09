package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.AddCalculator;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.ScannerArgumentResolver;

// JavaConfigファイルのクラスであることを指定する
@Configuration
public class AppConfig {
	// Diコンテナでに管理させたい@Beanアノテーション
	@Bean
	Calculator calculator() {
		return new AddCalculator();
	}

	// Diコンテナでに管理させたい@Beanアノテーション
	@Bean
	ArgumentResolver argumentResolver() {
		return new ScannerArgumentResolver();
	}
}
