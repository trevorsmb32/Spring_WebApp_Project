package com.emusicstore.dao;



import java.util.List;

import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.Product_working;


/**
 * Created by Le on 1/6/2016.
 */
public interface ProductDao_working {

    List<Product_working> getProductList();

    Product_working getProductById(int id);

    void addProduct(Product_working product);

    void editProduct(Product_working product);

    void deleteProduct(Product_working product);
}
