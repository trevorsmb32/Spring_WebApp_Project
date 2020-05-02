package com.emusicstore.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emusicstore.doa.registery.RegisteryDAO;
import com.emusicstore.pojo.Admin;

@RestController
public class restWebServiceController {

	@RequestMapping(value="/jsonGetAdminById/{adminId}", method=RequestMethod.GET)
	public String jsongetAdminId(@PathVariable("adminId")String id){
		Admin admin = RegisteryDAO.getUserDAO().getAdminById(id);
		
		JSONObject json = new JSONObject(admin);
		return json.toString();
	}
	
	@RequestMapping(value="/xmlGetAdminById/{adminId}", method=RequestMethod.GET)
	public Admin xmlgetAdminById(@PathVariable("adminId")String id){
		Admin admin = RegisteryDAO.getUserDAO().getAdminById(id);
		
		return admin;
		
	}

}
