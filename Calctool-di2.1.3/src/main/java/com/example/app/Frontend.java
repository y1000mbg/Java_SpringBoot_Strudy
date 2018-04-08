package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;

public class Frontend {
	/* 
	 * AutowiredアノテーションでDIコンテナが読み込む
	 * フィールドを指定できる
	 */
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;
	
	/*
	 * DiApplication.javaから呼ばれる実処理の実装
	 */
	public void run() {
		System.out.println("Enter 2 numbers like 'a b'");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(),argument.getB());
		System.out.println("result =" + result);
	}
}
