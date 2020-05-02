package com.emusicstore.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;


public class Authority implements GrantedAuthority {

    private String authority;
    
    
	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public String getAuthority() {
		return authority;
	}



}

