package com.example.app;

import lombok.Data;

/*
 * Dataアノテーションを付けるとコンパイル時に
 * setter/getterメソッド、toStringメソッド、equalsメソッド、hashCodeメソッドが生成される
 * final修飾子をつけるとsetterは生成されない
 */
@Data
public class Argument {
	private final int a;
	private final int b;
}
