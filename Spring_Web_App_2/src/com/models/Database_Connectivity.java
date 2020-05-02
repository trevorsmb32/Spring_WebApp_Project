package com.models;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database_Connectivity {

	//Establish a connection with the data source you want to use.
	Connection conn;
	//A Statement is an interface that represents a SQL statement.
	Statement statement;
	
	String url = "jdbc:mysql//:localhost:3306/";
	String db = "mydb";
	String username = "root";
	String password = "t3l3com";
	
	
	public Statement db_connection()
	{
		
		try
		{
			//dynamically load the driver which extends DriverManager. 
			//Then we get connection using DriverManager.getConnection() method.
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb","root","t3l3com");  
			//here sonoo is database name, root is username and password  
			Statement statement=con.createStatement();  
			
			return statement;
		}
		catch(Exception e){ System.out.println(e);}
		return null; 

	}
	
	
}
