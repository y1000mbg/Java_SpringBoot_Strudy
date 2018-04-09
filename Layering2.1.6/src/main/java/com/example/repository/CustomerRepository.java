package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.example.domain.Customer;

@Repository
public class CustomerRepository {
	// 何やりたいか調べる
	// Integerキー Customer型の値
	private final ConcurrentMap<Integer, Customer> CustomerMap = new ConcurrentHashMap<>();
	
	public List<Customer> findAll(){
		return new ArrayList<>(CustomerMap.values());
	}

	/*
	 * CustomerMap.getは整数値のキー（CustomerId）が指定されている 
	 * saveメソッドで整数値キー(CustomerId)とクラス型のCustomerコンストラクターの値が格納されている
	 * ※コンストラクタは id,firstName,lastName
	 * つまりHashMapで詰められている例としては以下の通り
	 * key 1 / value 1,Nobita,Nobi (これはコンストラクタ指定の段階で引数にする）  
	 * 
	 * 実際のコンストラクタ指定の引数はLayeringApplication.javaでCustomerService経由で
	 * 呼ばれる際の引数指定で実施される。
	 * LayeringApplication → 呼び出し → CustomerService → 呼び出し → CustomerRepository
	 * → Customer の順番。
	 * できるだけオブジェクト生成を別出しして抽象化していくイメージで各役割を細分化している様に感じる。
	 */
	 
	
	public Customer findOne(Integer CustomerId) {
		return CustomerMap.get(CustomerId);
	}
	
	public Customer save(Customer Customer) {
		return CustomerMap.put(Customer.getId(), Customer);
	}
	
	public void delete(Integer CutomerId) {
		CustomerMap.remove(CutomerId);
	}
}
