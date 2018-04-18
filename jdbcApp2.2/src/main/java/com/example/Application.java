/*
 * 【必要クラス】
 * com.example.domain.Customer.javaが必要
 * 
 * 【必要 SQLファイル】
 * src/main/resources/
 * schema.sql
 * (DDL用 ※テーブル作成)
 * 
 * data.sql
 * (DML用 ※データINSERT)
 * 
 * 【諸注意】
 * SQLファイルん内容を変更したらSTSのメニューからリフレッシュしないと反映されない
 * ファイル > リフレッシュ を実行すること
 * 
 */

package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.Customer;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplaate;

	@Override
	public void run(String... strings) throws Exception {

		// JDBCのpreparedstatmentではプレースホルダで?を指定していたが
		// Spring-bootでは:idなどで指定する
		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";

		// プレースホルダーに値を反映
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", 1);

		Customer result = jdbcTemplaate.queryForObject(sql, param, new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Customer(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"));
			}
		});

		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
