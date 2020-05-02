package com.emusicstore.junit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emusicstore.dao.iOrder;
import com.emusicstore.daoImpl.OrderDaoImpl;
import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Order;
import com.emusicstore.pojo.Product;
import com.emusicstore.service.ShoppingCartService;
import com.emusicstore.serviceImpl.ShoppingCartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-security-test.xml","classpath:spring-servlet-test.xml"})
public class ShoppingController_Test {

	private static final Logger logger = Logger.getLogger(ShoppingController_Test.class);

	@Autowired
	ShoppingCartService shoppingCartService;

	@Test
	public void ShoppingController(){
		int id =1;
		logger.debug("ShoppingController Attempting to addd item to cart:"+id);
		shoppingCartService.addToCart(id);
		shoppingCartService.addToCart(id);
		shoppingCartService.addToCart(id);
		logger.debug("ShoppingController: populated cart with the id:"+shoppingCartService.getTotal());

	}

	@Test
	public void checkout() {
		List<Item> items = shoppingCartService.getCartItems();

		ModelAndView mav = new ModelAndView("checkOut");
		mav.addObject("items",items);

		Order order = new Order();
		order.createOrder(shoppingCart);
		iOrder orderDao = new OrderDaoImpl();
		orderDao.addOrder(order);
		logger.info("Order Saved with Id"+order.getId());


		return mav;

	}



}

}
