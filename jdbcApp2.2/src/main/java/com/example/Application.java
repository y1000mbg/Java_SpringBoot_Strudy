package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplaate;

	@Override
	public void run(String... strings) throws Exception {
		
		// JDBCのpreparedstatmentではプレースホルダで?を指定していたが
		// Spring-bootでは:aなどで指定する
		String sql = "SELECT :a + :b";

		// プレースホルダーに値を反映
		SqlParameterSource param = new MapSqlParameterSource()
		.addValue("a",100)
		.addValue("b", 200);
		
		// queryForObjectメソッドを使ってSQL実行結果をオブジェクトに変換
		Integer result = jdbcTemplaate.queryForObject(sql, param, Integer.class);
		
		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
