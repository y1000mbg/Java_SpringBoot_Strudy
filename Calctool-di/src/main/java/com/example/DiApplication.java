package com.example;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.example.app.Calculator;

/* Spring-Boot-Applicationの自動設定アノテーション
 * @SpringBootApplicationはEnableAutoConfigurationも含まれている
*/
@EnableAutoConfiguration

// 読み込みJavaConfigを指定する
@Import(AppConfig.class)
public class DiApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DiApplication.class, args);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 2 numbers like 'A B'");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		Calculator calculator = context.getBean(Calculator.class);
		int result = calculator.calc(1, b);
		System.out.println("resrult = " + result);
				
	}
}
