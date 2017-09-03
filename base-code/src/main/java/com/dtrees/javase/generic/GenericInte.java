package com.dtrees.javase.generic;

public interface GenericInte<T> {

	@SuppressWarnings("hiding")
	public <T> void addEle(T t);
	
	@SuppressWarnings("hiding")
	public <T>  boolean isExit();
	
	@SuppressWarnings("hiding")
	public <T> T getEle();
}
