package com.dtrees.javase.generic;

import com.dtrees.javase.bean.Person;
import com.dtrees.javase.bean.Student;

import java.util.Collection;



public class GenericClass<G> {

	//对象调用的泛型方法
	@SuppressWarnings("hiding")
	public <G> void method(G g){
		
	}
	
	
	@SuppressWarnings("hiding")
	public <G> G show(G g){
		return g;
	}
	
	
	/*
	 * 上限
	 */
	public void add(Collection<? extends Person> c){
		
	}
	/*
	 * 下限
	 */
	public void find(Collection<? super Student> c){
		
	}
	
	/*
	 * 通配符？,未知类型
	 */
	@SuppressWarnings("hiding")
	public <G> void modify(G g){
		
	}
	
	/*
	 * 静态方法，必须指明类型，其不依赖于对象
	 */
	
	public static <T> void getMax(){
		
	}
	
	public static <T> T get(T t){
		return t;
	}
	
}
