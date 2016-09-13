package com.formation.emma.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emma.dao.CustomerDAO;
import com.formation.emma.metier.Customer;

public class MainSpringBdd {

	public static void main(String[] args) {
		MainSpringBdd main = new MainSpringBdd();
		main.init();
	}

	private void init() {
		ApplicationContext app = new ClassPathXmlApplicationContext("Spring_Customer.xml");
		Customer customer = new Customer(3, "Alphonce", 18);
		CustomerDAO customerDAO = (CustomerDAO) app.getBean("customerDAO");
		customerDAO.insertCustomer(customer);
		Customer customerRecup = customerDAO.findCustomerById(1);
		System.out.println(customerRecup);
	}
}
