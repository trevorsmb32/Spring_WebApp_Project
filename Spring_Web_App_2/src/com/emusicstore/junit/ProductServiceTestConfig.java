package com.emusicstore.junit;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.emusicstore.dao.iProductDAO;
import com.emusicstore.daoImpl.ProductDAOMock;
import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.service.ProductService;
import com.emusicstore.serviceImpl.ProductServiceImpl;


public class ProductServiceTestConfig {


    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(config);
        //sessionFactory.setPackagesToScan("com.da");
        sessionFactory.setPackagesToScan("com.models");
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("t3l3com");

        return dataSource;
    }


    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);

       return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
       return new PersistenceExceptionTranslationPostProcessor();
    }
    @Bean
    public ProductDaoImpl ProductDAO() {
        return new ProductDaoImpl();        
    }

    @Bean
    public ProductService ProductService() {
        return new ProductServiceImpl();
    }
}

