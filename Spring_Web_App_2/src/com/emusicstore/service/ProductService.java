package com.emusicstore.service;
import java.util.List;

import com.emusicstore.pojo.Product;


public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(int id);

    void deleteProduct(int id);
}
