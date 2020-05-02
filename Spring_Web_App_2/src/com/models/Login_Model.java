package com.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.emusicstore.pojo.Admin;

public class Login_Model {

	public String login_commit_process(String username, String password){
		
		try{
			
			Database_Connectivity dc = new Database_Connectivity();
			Statement statement = dc.db_connection();
			
			//Create database query using Result Set			
			ResultSet rs = statement.executeQuery("select * from administration where username='"+username+"' and password='"+password+"';");

			int count=0;
			//Calls next, the method outputs the data in the row where the cursor is currently positioned
			while(rs.next()){
					
					count=rs.getInt(1);
				
			}
			rs.close();
			
			if(count >= 1){
				
				return "login succesful";
			}
			
			else{

				return "login failed";
			}
		}
		
		catch(Exception e){
			
			return "Error in authentication process";
		}
		
	}
//	
//	public String hibernateLogin(String username, String password){
//		try{
//			SessionFactory sessionFactory = HibernateUtil2.buildSessionFactory();
//			Session session = sessionFactory.getCurrentSession();
//			
//			session.beginTransaction();
//			
//			List<Admin> admin = session.createQuery("From Admin where username='"+username+"' and password='"+password+"'").list();
//			System.out.println("From Admin where username='"+username+"' and password='"+password+"'");
//
//			session.close();
//			
//			if(admin.size() ==1) return "login success";
//	
//			else return "Please try again";
//			
//		}
//		catch(Exception e){
//			return "Login failed";
//			
//		}
//	}
//	
}
