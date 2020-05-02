package com.emusicstore.pojo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement(name="admin")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="administration")
public class Admin {

	@Id
	@Column(name="adminID")
	int adminID;
	@NotBlank(message="Email cannot be blank")
	@Column(name="email")
	String username;
	@Size(min=6, max=14, message="password too short")
	@Column(name="password")
	String password;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="role_id")
	Roles role;
	
	
	public Admin(String username, String password, Roles role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole() {
		this.role=role;
	}
	
	public Roles getRole() {
		return role;
	}
	
}
