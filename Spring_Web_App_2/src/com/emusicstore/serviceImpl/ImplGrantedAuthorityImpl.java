package com.emusicstore.serviceImpl;

import org.springframework.security.core.GrantedAuthority;

public class ImplGrantedAuthorityImpl implements GrantedAuthority {

	String authority;

	public ImplGrantedAuthorityImpl(String authority) {
		super();
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}


	public void setAuthority(String authority) {
		authority = authority;
	}
	
}
