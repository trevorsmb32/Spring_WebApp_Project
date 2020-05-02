package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.pojo.ShippingAddress;

public interface iShippingAddressDAO {
	
	  void addShippingAddress(ShippingAddress shippingAddress);
	
	  void deleteShippingAddress(int id);
	  
	  ShippingAddress getShippingAddress(int id);
	  
	  List<ShippingAddress> getAllShippingAdresses();

}
