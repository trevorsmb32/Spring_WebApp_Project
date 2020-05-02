package com.emusicstore.daoImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.emusicstore.pojo.Product;

@Repository
public class ProductDAOMock {
	
	public Product getProduct() {
		
		Product p =new Product();
		p.setId(7);
		p.setName("Mock DB Prod");
		
		return p;
		
	}

}
