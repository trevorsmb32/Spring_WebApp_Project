package com.emusicstore.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String roles;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Customer> customers;

	public Roles() {
		
	}
	
	
	public Roles(String roles) {
		super();
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}	


	
}
