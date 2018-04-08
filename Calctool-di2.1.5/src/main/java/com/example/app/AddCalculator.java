package com.example.app;

import org.springframework.stereotype.Component;

// ComponentScanアノテーションで読まれる対象
@Component
public class AddCalculator implements Calculator {
	@Override
	public int calc(int a,int b) {
		return a+b;
	}
}
