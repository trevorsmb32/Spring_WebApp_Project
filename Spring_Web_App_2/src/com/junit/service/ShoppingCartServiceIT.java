package com.junit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.junit.ProductServiceTestConfig;
import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.ShoppingCart;
import com.emusicstore.service.ProductService;
import com.emusicstore.service.ShoppingCartService;
import com.emusicstore.serviceImpl.ItemServiceImpl;
import com.emusicstore.serviceImpl.ShoppingCartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-security-test.xml","classpath:spring-servlet-test.xml"})
public class ShoppingCartServiceIT {


	@Autowired
	ItemServiceImpl itemServiceImpl;
	@Autowired
	ProductService productService;


	@Test
	public void addToCart() {
		int id=1;
		ShoppingCart sc = new ShoppingCart();
		System.out.print("...."+productService.getProductById(id));
		Item item=itemServiceImpl.convertItem(productService.getProductById(id));
		boolean isExist = false;
		double totalNumber=0;
		for (Item c : sc.getItems()) {
			if (c.equals(item)){
				c.setQuantity((int) (c.getQuantity() + 1));
				isExist = true;
			}
			totalNumber = totalNumber+c.getQuantity()*c.getPrice();

		}
		if (isExist == false) {
			sc.addItem(item);
			totalNumber = totalNumber+item.getQuantity()*item.getPrice();

		}
		sc.setTotal(totalNumber);
		System.out.print("the total number is +:"+totalNumber);
	}
}
