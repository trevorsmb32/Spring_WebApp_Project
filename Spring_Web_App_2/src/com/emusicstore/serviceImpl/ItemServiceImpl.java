package com.emusicstore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.ItemDAO;
import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.ShoppingCart;
import com.emusicstore.service.ItemService;
import com.emusicstore.service.ShoppingCartService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDAO itemdao;

	@Override
	public Item convertItem(Product product) {
		Item item = new Item();
		item.setName(product.getName());
		item.setId(product.getId());
		item.setName(product.getName());
		item.setPrice(product.getPrice());
		item.setQuantity(1);
		
		return item;
	}

	
	public void addItems(List<Item> items) {
		for (Item x: items) {
			System.out.print("Adding item"+x);
			itemdao.addItem(x);
		}
		
	}
}
