package com.example.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * @AllArgsConstructorはLombokで使用するアノテーションで
 * 全フィールドの引数を持つコンストラクタを生成する。
 */

@Data
@AllArgsConstructor
public class Customer implements Serializable {
	private Integer id;
	private String firstName;
	private String lastName;
	
}
