package com.emusicstore.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.models.HibernateConnection;
import com.emusicstore.dao.iUserDAO;
import com.emusicstore.daoImpl.HibernateUtil2;
import com.emusicstore.pojo.Admin;

public class userDaoImpl implements iUserDAO {

	public String doHibernateLogin(String username, String password){
		try{
			SessionFactory sessionFactory = HibernateUtil2.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			List<Admin> admin = session.createQuery("From Admin where username='"+username+"' and password='"+password+"'").list();
			System.out.println("Hibernate Login Success....do Hibernate Login");
			
			session.close();

			if(admin.size() ==1) return "login success";
			
			else return "Please try again";
		}
		catch(Exception e){
			return "Please try again...";
		}
	}


	public String doHibernateSignUp(Admin admin){
		try{
			Session session = HibernateUtil2.getSessionFactory().openSession(); 
			session.beginTransaction();

			session.save(admin);

			session.getTransaction().commit();
			session.close();
			return "user Added";
		}
		catch(Exception e){
			e.printStackTrace();
			return "User Not added";
		}
	}

	public boolean deleteProductbyId(String id){
		try{
			Session session = HibernateUtil2.getSessionFactory().openSession();

			List<Admin> admin = session.createQuery("From Admin where id'"+id+"'").list();

			if(admin != null && admin.get(0) != null){
				session.beginTransaction();
				session.delete(admin.get(0));
				session.getTransaction().commit();
				session.close();


			}

			return true;

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}


	}


	@Override
	public Admin getAdminById(String id) {
		try{
			Session session = HibernateUtil2.getSessionFactory().openSession();
			
			List<Admin> admin = session.createQuery("From Admin where id='"+id+"'").list();
			
			return admin.get(0);
 			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}

