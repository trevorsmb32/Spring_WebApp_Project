package com.emusicstore.serviceImpl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.dao.iProductDAO;
import com.emusicstore.daoImpl.ProductDAOMock;
import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.pojo.Product;
import com.emusicstore.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById (int productId) {
        return productDao.getProductById(productId);
    }

    public List<Product> getProductList () {
        return productDao.getAllProducts();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(int id) {
        productDao.editProduct(id);
    }

    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }


}