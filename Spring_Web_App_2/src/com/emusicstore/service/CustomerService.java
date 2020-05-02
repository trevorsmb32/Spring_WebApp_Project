package com.emusicstore.service;

import java.util.List;

import com.emusicstore.pojo.Customer;

public interface CustomerService {
	
	List<Customer> getCustomerList();
	
	void addCustomer(Customer customer);
	
	void editCustomer(int id);
	
	void updateCustomer(int id);
	
	Customer getCustomer(String email);

}
