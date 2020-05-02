package com.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emusicstore.daoImpl.userDaoImpl;
import com.emusicstore.doa.registery.RegisteryDAO;
import com.emusicstore.pojo.Admin;
import com.models.SignUp_model;

@Controller
public class signUpController {


	@RequestMapping(value="/signUp",method=RequestMethod.GET)
	public ModelAndView SignUp(){

		ModelAndView mav = new ModelAndView("signUp");		
		Admin admin = new Admin();
		mav.addObject("admin",admin);

		return mav;

	}

	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public ModelAndView SignUp_commit(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("signUp");

		String message;
		Admin admin = new Admin();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("repassword");

		admin.setUsername(username);
		admin.setPassword(password);

		if(password.equals(password2)){

			message = RegisteryDAO.getUserDAO().doHibernateSignUp(admin);	
		
		}

		else{

			message = "user not Added to DB";
		}

		mav.addObject("message", message);

		return mav;

	}
}