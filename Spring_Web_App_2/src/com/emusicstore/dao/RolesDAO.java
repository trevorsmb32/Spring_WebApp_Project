package com.emusicstore.dao;

import java.util.List;

import org.springframework.context.annotation.Role;

import com.emusicstore.pojo.Roles;

public interface RolesDAO {

	void addRole(Roles role);
	void delteRole(int id);
	List<Roles> listRoles();
	void updateRole(int id);
	Roles getRole(int id);
	
}
