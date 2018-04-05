package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring-Boot-Applicationの自動設定アノテーション
@SpringBootApplication

// Webアプリケーション設定用のアノテーション
@RestController
public class HelloWorldApplication {
	
	/* GETメソッドを受け付ける。
	 * /にアクセスがあればhomeメソッドが呼び出される
	 */
	@GetMapping("/")
	String home() {
		return "Hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
