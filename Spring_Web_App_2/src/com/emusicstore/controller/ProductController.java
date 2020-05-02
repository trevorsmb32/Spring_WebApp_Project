package com.emusicstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emusicstore.dao.iProductDAO;
import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.pojo.Product;
import com.emusicstore.service.ProductService;


@Controller
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
   
  
	@RequestMapping(value="/productList",method=RequestMethod.GET)
	public String productList(Model model){

		logger.info("productList page attempted GET");
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	
}

