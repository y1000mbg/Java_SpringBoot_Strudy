package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Customer;
import com.example.service.CustomerService;

import lombok.AllArgsConstructor;

@SpringBootApplication
public class LayeringApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;
	
	@Override
	public void run(String ...strings ) throws Exception {
		
		/*
		 * 第1フェイズ
		 * new CutomerはCustomer.javaの定義でprivate定義していた箇所で
		 * @AllArgsConstructorのおかげで、private定義されているid,firstName,lastNameが
		 * コンストラクタ作成時にセットされる
		 * 
		 */
		
		//データの追加
		customerService.save(new Customer(1,"Nobita","Nobi"));
		customerService.save(new Customer(2,"Takeshi","Goda"));
		customerService.save(new Customer(3,"Suneo","Honekawa"));
		
		//データの表示
		customerService.findAll().forEach (System.out :: println) ;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LayeringApplication.class, args);
	}
}
