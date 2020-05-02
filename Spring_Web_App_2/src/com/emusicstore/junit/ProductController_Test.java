package com.emusicstore.junit;

import java.io.IOException;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.emusicstore.dao.ProductDao;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-security-test.xml","classpath:spring-servlet-test.xml"})
public class ProductController_Test {


	@Autowired
	ResourceLoader resourceLoader;  


	@Autowired
	private ProductService productService;
   
  
	@Test
	public void productList(){
		List<Product> products = productService.getProductList();
		System.out.print(productService.getProductList().toString());

	}
	
}
