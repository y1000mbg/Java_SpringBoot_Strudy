package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;

/*
 * CommandLineRunerインタフェイスはDiApplicationクラスから
 * 直接Autowiredとrunメソッドを実装できる
 * 2.1.5ではFrontendクラスが該当していた処理を集約化した
 */

@SpringBootApplication
public class DiApplication implements CommandLineRunner {
	
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;
	
	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Enter 2 numbers like 'A B'");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class);
	}
}
