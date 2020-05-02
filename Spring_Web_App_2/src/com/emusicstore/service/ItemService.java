package com.emusicstore.service;

import java.util.List;

import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Product;

public interface ItemService {
	
	public Item convertItem(Product product);
	
	public void addItems(List<Item> item);

}
