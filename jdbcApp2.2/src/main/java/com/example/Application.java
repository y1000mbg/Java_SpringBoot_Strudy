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

/*
 * Log4jdbcの設定を追加
 * 
 * 設定はsrc/main/resources/application.propetiesせ設定追加
 * 
 * 実行時ログに下記の様のSQLの実行ログが出力される
2018-04-18 15:04:00.623 DEBUG 11868 --- [           main] jdbc.sqltiming                           :  com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:95)
1. INSERT INTO customers (first_name,last_name) VALUES('Nobita','Nobi')  {executed in 3 msec}
2018-04-18 15:04:00.624 DEBUG 11868 --- [           main] jdbc.sqltiming                           :  com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:95)
1. INSERT INTO customers (first_name,last_name) VALUES('Takeshi','Goda')  {executed in 0 msec}
2018-04-18 15:04:00.624 DEBUG 11868 --- [           main] jdbc.sqltiming                           :  com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:95)
1. INSERT INTO customers (first_name,last_name) VALUES('Suneo','Honekawa')  {executed in 0 msec}
2018-04-18 15:04:00.625 DEBUG 11868 --- [           main] jdbc.sqltiming                           :  com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:95)
1. INSERT INTO customers (first_name,last_name) VALUES('Shizuka','Minamoto')  {executed in 0 msec}
2018-04-18 15:04:00.917 DEBUG 11868 --- [           main] jdbc.sqltiming                           :  com.zaxxer.hikari.pool.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:52)
1. SELECT id, first_name, last_name FROM customers WHERE id = 1  {executed in 3 msec}
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
