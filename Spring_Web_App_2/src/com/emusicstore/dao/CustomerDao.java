package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.pojo.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);
	void updateCustomer(int id);
	Customer getCustomer(String email);
	List<Customer> listCustomers();


}
