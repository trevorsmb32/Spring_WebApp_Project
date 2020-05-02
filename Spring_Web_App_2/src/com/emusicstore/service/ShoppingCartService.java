package com.emusicstore.service;

import java.util.Iterator;
import java.util.List;

import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.ShoppingCart;
import com.emusicstore.serviceImpl.ProductServiceImpl;

public interface ShoppingCartService {

	public ShoppingCart getShoppingCart();

	public List<Item> getCartItems();
	
	public void setTotal();
		
	public double getTotal();

	public void deleteFromCart(int id);

	public void editCart(int id,int quantity);

	public void addToCart(int id);

	
}
