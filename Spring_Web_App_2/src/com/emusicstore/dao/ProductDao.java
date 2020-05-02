package com.emusicstore.dao;



import java.util.List;

import com.emusicstore.pojo.Product;



public interface ProductDao {

    List<Product> getAllProducts();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(int id);

    void deleteProduct(int id);
}
