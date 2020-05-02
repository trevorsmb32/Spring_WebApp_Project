package com.emusicstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.emusicstore.pojo.Product;

public interface iProductDAO {

	void addProduct(Product product);

	void editProduct(int id);

	Product getProductById(int id);

	List<Product> getAllProducts();

	void deleteProduct(int id);

}

