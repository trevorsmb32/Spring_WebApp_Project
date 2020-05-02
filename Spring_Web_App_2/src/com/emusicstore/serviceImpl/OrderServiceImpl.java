package com.emusicstore.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.ItemDAO;
import com.emusicstore.dao.OrderDao;
import com.emusicstore.daoImpl.ItemDAOImp;
import com.emusicstore.pojo.Customer;
import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Order;
import com.emusicstore.pojo.ShoppingCart;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ItemService;
import com.emusicstore.service.OrderService;
import com.emusicstore.service.ShoppingCartService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	OrderDao orderDao;
	@Autowired
	CustomerService customerService;
	@Autowired
	ItemDAO itemdao;
	@Autowired
	ItemService itemService;
	
	
	Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	public void createOrder(ShoppingCartService shoppingCartService) {
		
		// Get the user from the active session
		logger.debug("OrderService: createOrder");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		Customer customer = customerService.getCustomer(username);
		
		// Add Items to Database
		List<Item> items = shoppingCartService.getShoppingCart().getItems();
		itemService.addItems(items);
		
		// Create an order and Add to Database
		Order order = new Order();
		order.createOrder(shoppingCartService.getShoppingCart(), customer);
		orderDao.addOrder(order);
		logger.debug("OrderService: createOrder: completed");
		
	}
	
}
