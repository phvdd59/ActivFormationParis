package com.formation.emma.metier;

public class Customer {

	private int cust_Id;
	private String name;
	private int age;
	
		public Customer(int cust_Id, String name, int age) {
		super();
		this.cust_Id = cust_Id;
		this.name = name;
		this.age = age;
	}
		
	public int getCust_Id() {
		return cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [cust_Id=" + cust_Id + ", name=" + name + ", age=" + age + "]";
	}
	
}
