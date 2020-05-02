package com.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.emusicstore.pojo.Admin;


public class SignUp_model {

	public String SignUp_commit(String username, String password){
		
		try{
			
			System.out.println("Attempting commit");
			Database_Connectivity dc = new Database_Connectivity();
			Statement statement = dc.db_connection();
			
			statement.execute("insert into administration (userName,password) Values('"+username+"','"+password+"');");
			
			return "Mysql done";
		}
		
		
		catch(Exception e){
			System.out.println(e);
			return "not done";
		}
		
	}
	
}
