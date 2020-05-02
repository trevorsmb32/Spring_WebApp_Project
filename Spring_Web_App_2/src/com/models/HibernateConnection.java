package com.models;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.emusicstore.pojo.Admin;

public class HibernateConnection {
	
	public static SessionFactory sessionFactory;
	
	public static SessionFactory hibernateConnection(){
		Properties database = new Properties();
		database.setProperty("hibernate.connection.driver_class", "com.sql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "root");
		database.setProperty("hibernate.connection.password", "t3l3com");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		Configuration cfg = new Configuration()
							.setProperties(database)
							.addPackage("com.pojo")
							.addAnnotatedClass(Admin.class);
		
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		
		return sessionFactory;
	}

}
