package com.emusicstore.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.emusicstore.dao.ShoppingCartDAO;
import com.emusicstore.pojo.ShoppingCart;

public class ShoppingCartDaoImpl implements ShoppingCartDAO  {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addCart(ShoppingCart sc) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(sc);
		session.flush();		
	}
}