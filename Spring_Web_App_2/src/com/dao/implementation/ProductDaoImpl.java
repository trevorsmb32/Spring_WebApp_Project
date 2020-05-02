package com.dao.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.iProductDAO;
import com.emusicstore.pojo.Product;

public class ProductDaoImpl implements iProductDAO {


    private static final Logger logger = Logger.getLogger(ProductDaoImpl.class);

    
    private SessionFactory sessionFactory;
    

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        // Close resources
        sessionFactory.close();

    }

    public void editProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class,id);
        session.update(product);
        session.getTransaction().commit();
        //session.close();
        session.flush();


    }


    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class,id);

        return product;
    }

    @Transactional
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Product> products = session.createQuery("From Product").list();
        logger.debug("Query List Executed"+session.createQuery("From Product").list());
        tx.commit();
        

        return products;
    }


    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class,id);
        session.delete(product);
        session.getTransaction().commit();
        //session.close();
        session.flush();

    }

}