package com.testPackage;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.emusicstore.pojo.Admin;
import com.models.HibernateUtil;

public class HibernateLog4jExample {

	static{
		System.out.println("Before log4j configuration");
		System.out.println("After log4j configuration");
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		//Get All Employees
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Admin");
		List<Admin> adminList = query.list();
		for(Admin admin : adminList){
			session.createQuery("From Admin").list();
			System.out.println("YOur in the loop"+admin.getUsername());
		}
		
		tx.commit();
		sessionFactory.close();
	}

}