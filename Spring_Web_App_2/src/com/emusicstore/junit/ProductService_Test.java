package com.emusicstore.junit;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.emusicstore.daoImpl.ProductDAOMock;
import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Product;
import com.emusicstore.service.ProductService;
import com.emusicstore.serviceImpl.ShoppingCartServiceImpl;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ProductServiceTestConfig.class})
public class ProductService_Test {
	
	private static final Logger logger = Logger.getLogger(ShoppingController_Test.class);
	
	@Autowired
	private ProductService productService;
	

	@Test
	public void testSC() {
		
		logger.debug("ProductService: Accessing ProductService_Test");
		//Product p = productService.getProductDaoMock();

		System.out.print("!!!!!!!"+productService.getProductList());
	}
	
}
