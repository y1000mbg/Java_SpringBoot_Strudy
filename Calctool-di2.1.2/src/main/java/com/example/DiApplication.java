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

		// 画面の表示
		System.out.println("Enter 2 numbers like 'A B'");
		
		// JavaConfig設定の読み込み ※ArgumentResolver.class
		ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
		
		// ArgumentResolverインタフェースの実装クラスのresolveメソッドの読み出し（中身はscanner)
		Argument argument = argumentResolver.resolve(System.in);
		
		// JavaConfig設定の読み込み ※Calculator.class
		Calculator calculator = context.getBean(Calculator.class);
		
		
		int result = calculator.calc(argument.getA(),argument.getB());
		System.out.println("result = " + result);
	}
}
