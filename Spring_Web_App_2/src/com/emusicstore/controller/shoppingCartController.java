package com.emusicstore.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.emusicstore.daoImpl.OrderDaoImpl;
import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Order;
import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.ShoppingCart;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.OrderService;
import com.emusicstore.service.ShoppingCartService;
import com.emusicstore.serviceImpl.ShoppingCartServiceImpl;

@Controller
@Scope(value="session")
public class shoppingCartController {

	private static final Logger logger = Logger.getLogger(shoppingCartController.class);

	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	OrderService orderService;


	@RequestMapping(value="shoppingCart",method=RequestMethod.GET)
	public ModelAndView shoppingCartController(HttpSession session){

		ModelAndView mav = new ModelAndView("shoppingCart");
		List<Item> items = shoppingCartService.getCartItems();
		mav.addObject("items",items);
		mav.addObject("shoppingCart", shoppingCartService);

		return mav;
	}

	@RequestMapping(value="/addToShoppingCart/{id}", method=RequestMethod.GET)
	public String ShoppingController(@PathVariable("id")int id, Model model,HttpSession session){

		logger.debug("ShoppingController Attempting to addd item to cart:"+id);
		shoppingCartService.addToCart(id);
		logger.debug("ShoppingController: populated cart with the id:"+shoppingCartService.getTotal());

		model.addAttribute("shoppingCart", shoppingCartService);

		return "redirect:/productList";
	}


	@RequestMapping(value="/removeFromCart/{id}",method=RequestMethod.GET)
	public String viewProduct(@PathVariable("id")int id,HttpSession session){

		shoppingCartService.deleteFromCart(id);

		return "redirect:/shoppingCart";

	}


	@RequestMapping(value="cart/{id}/updateItem/{quantity}",method=RequestMethod.GET)
	public String editProduct(@PathVariable("id")int id,@PathVariable("quantity")int quantity,HttpSession session){

		shoppingCartService.editCart(id, quantity);
		logger.info("Id is:"+id+"quantity:"+quantity);

		return "redirect:/shoppingCart";

	}


	@RequestMapping(value="shoppingCart/checkOut",method=RequestMethod.GET)

	public ModelAndView checkOut(HttpSession session,Model model){

		List<Item> items = shoppingCartService.getCartItems();
		ModelAndView mav = new ModelAndView("checkOut");
		mav.addObject("items",items);

		orderService.createOrder(shoppingCartService);
		//order.createOrder(shoppingCart);
		//OrderDao orderDao = new OrderDaoImpl();
		//orderDao.addOrder(order);
		//logger.info("Order Saved with Id"+order.getId());


		return mav;

	}


}