package com.emusicstore.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.emusicstore.pojo.Customer;
import com.emusicstore.pojo.Roles;

public class MyUserPrincipalimpl implements UserDetails {
    private Customer customer;
 
    public MyUserPrincipalimpl(Customer customer) {
        this.customer = customer;
    }

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Roles role= customer.getRole();
		List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
	    if(role!= null)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new ImplGrantedAuthorityImpl(role.getRoles());
                grantList.add(authority);
            }
		
		return grantList;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}