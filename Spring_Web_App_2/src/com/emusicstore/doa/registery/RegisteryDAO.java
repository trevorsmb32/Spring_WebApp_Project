package com.emusicstore.doa.registery;


import com.emusicstore.dao.iUserDAO;
import com.emusicstore.daoImpl.userDaoImpl;

public class RegisteryDAO {

	public static iUserDAO userDAO;
	
	static{
		userDAO = new userDaoImpl();
	}


	public static void setuserDAO(iUserDAO userDAO) {
		RegisteryDAO.userDAO = userDAO;
	}
	
	public static iUserDAO getUserDAO() {
		return userDAO;
	}

	
}