package com.formation.made.metier;

import java.io.Serializable;

public class Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name;
	private int age;
	private int id;
	
	
	
	public Personne() {
		super();
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Personne [Name=" + Name + ", age=" + age + ", id=" + id + "]";
	}
	
}
