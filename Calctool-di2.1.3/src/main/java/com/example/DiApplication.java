package com.example;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;

/* Spring-Boot-Applicationの自動設定アノテーション
 * @SpringBootApplicationはEnableAutoConfigurationも含まれている
*/
@EnableAutoConfiguration

// 読み込みJavaConfigを指定する
@Import(AppConfig.class)
public class DiApplication {
	
	public static void main(String[] args) {
		
		// 実行するSpring-Boot-Application
		ApplicationContext context = SpringApplication.run(DiApplication.class, args);
		
		Frontend frontend = context.getBean(Frontend.class);
		
		frontend.run();
		
	}
}
