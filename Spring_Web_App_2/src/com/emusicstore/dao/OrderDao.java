package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.pojo.Order;


public interface OrderDao {

	void addOrder(Order order);

	Order getOrderById(int id);

	List<Order> getAllOrders();

	void deleteOrder(int id);
	
}
