package com.formation.phva.metier;

public class GenericExo<T> {

	private T t;
	
	public GenericExo() {
	}
	
	public GenericExo(String s){
	}
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
