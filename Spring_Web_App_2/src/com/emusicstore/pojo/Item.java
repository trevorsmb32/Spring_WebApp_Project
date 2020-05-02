package com.emusicstore.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name="Item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int quantity;
	private double price;
	
	private static final Logger logger = Logger.getLogger(Item.class);


	public Item(){
		
	}
	
	public Item(String name, int quantity, int price,ShoppingCart shoppingCart) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public void setQuantity(int d) {
		this.quantity = d;
	}

	public double getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object obj) {
		logger.debug("Item object: comparing object"+((Item) obj).getName());
		return this.getName() == ((Item) obj).getName();
	}





}
