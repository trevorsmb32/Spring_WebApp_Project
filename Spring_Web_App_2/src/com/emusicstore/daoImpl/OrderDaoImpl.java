package com.emusicstore.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emusicstore.dao.OrderDao;
import com.emusicstore.pojo.Order;
import com.emusicstore.pojo.Product;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

	public void addOrder(Order order){		
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		session.flush();
	}

	public void deleteOrder(int id){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(id);
		
	}

	public Order getOrderById(int id){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Order order = (Order) session.get(Order.class,id);
		session.flush();
		
		return order;		
		
	}

	public List<Order> getAllOrders(){
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = session.createQuery("From Order").list();
		session.flush();

		return orders;
		
	}





}
