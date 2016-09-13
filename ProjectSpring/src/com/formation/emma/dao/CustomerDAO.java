package com.formation.emma.dao;

import com.formation.emma.metier.Customer;

public interface CustomerDAO {

	public Customer findCustomerById(int id);
	public void insertCustomer(Customer customer);
}
