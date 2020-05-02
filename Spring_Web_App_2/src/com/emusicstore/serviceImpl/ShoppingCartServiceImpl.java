package com.emusicstore.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.pojo.Item;
import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.ShoppingCart;
import com.emusicstore.service.ItemService;
import com.emusicstore.service.ProductService;
import com.emusicstore.service.ShoppingCartService;

@Service
@Scope(value = "session")
public class ShoppingCartServiceImpl implements ShoppingCartService {


	@Autowired
	ItemService itemServiceImpl;
	@Autowired
	ProductService productService;
	ShoppingCart shoppingCart = new ShoppingCart();
	double total;

	public static final Logger logger = Logger.getLogger(ShoppingCartServiceImpl.class);


	public void deleteFromCart(int id) {
		Iterator <Item> itr = shoppingCart.getItems().iterator();
		while (itr.hasNext()){
			Item item = itr.next();
			logger.info("Looping through item found: "+item.getName());
			if (item.getId() == (id)) {
				logger.info("Removing "+item.getName());
				shoppingCart.setTotal(shoppingCart.getTotal()-(item.getQuantity()*item.getPrice()));
				logger.info("This.total after subtraction: "+shoppingCart.getTotal());
				itr.remove();
			}
		}

	}

	public void editCart(int id,int quantity) {
		double totalNumber=0;
		for (Item c : shoppingCart.getItems()) {
			if (c.getId() == (id)) {
				c.setQuantity(quantity);
				logger.info("Quantity has been updated to: "+c.getQuantity());
			}
			logger.info("Loop: "+c.getId()+"Quantity is now "+c.getQuantity()+"Price is now "+c.getPrice());
			totalNumber = totalNumber+c.getQuantity()*c.getPrice();
			logger.info("Total Price is now "+totalNumber);
		}
		shoppingCart.setTotal(totalNumber);
	}


	public void addToCart(int id) {
		Item item=itemServiceImpl.convertItem(productService.getProductById(id));
		logger.debug("ShoppingCartServiceImpl: Adding item to Cart"+item.getName());
		boolean isExist = false;
		double totalNumber=0;
		for (Item c : shoppingCart.getItems()) {
			logger.debug(item.getName()+"ShoppingCartServiceImpl: Loop through shopping cart item"+c.getName());
			if (c.getName().equals(item.getName())){
				logger.debug("ShoppingCartServiceImpl: Items match"+c.getName());
				c.setQuantity((int) (c.getQuantity() + 1));
				isExist = true;
			}
			totalNumber = totalNumber+c.getQuantity()*c.getPrice();

		}
		if (isExist == false) {
			shoppingCart.addItem(item);
			totalNumber = totalNumber+item.getQuantity()*item.getPrice();

		}
		shoppingCart.setTotal(totalNumber);
		System.out.print("the total number is +:"+totalNumber);
	}


	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public List<Item> getCartItems() {	
		return shoppingCart.getItems();
	}

	public void setTotal() {	
		this.total=shoppingCart.getTotal();
	}

	public double getTotal() {	
		return shoppingCart.getTotal();
	}

}
