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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String firstName;
	public String secondName;
	public String email;
	public String password;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn()
	ShippingAddress shippingAddress;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	List<Order> orders;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "role_id")
	Roles role;

	
	
	public Customer() {
		super();
	}

	public Customer(String firstName, String secondName, String email, String password,
			ShippingAddress shippingAddress, Roles role) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.role = role;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Roles getRole() {
		return role;
	}


	public void setRole(Roles role) {
		this.role = role;
	}


	
}
