package com.emusicstore.serviceImpl;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.pojo.Customer;
import com.emusicstore.pojo.Roles;
import com.emusicstore.service.CustomerService;

@Service("LoginUserDetailsServiceImpl")
@Transactional
public class LoginUserDetailsServiceImpl implements UserDetailsService  {

	private static final Logger logger = Logger.getLogger(UserDetailsService.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public UserDetails loadUserByUsername(String  email) throws UsernameNotFoundException {
		logger.info("Customer DAO Email:" +email);
		Customer customer = customerDao.getCustomer(email);
		logger.info("Customer DAO Email:" +customer.getEmail());		
		Roles role = customer.getRole();
		logger.info("Customer DAO Role:" + role.getRoles());
		MyUserPrincipalimpl principal = new MyUserPrincipalimpl(customer);
		
		
		logger.info("customerUserDetails DAO:" +principal);
	       if (customer == null) {
	            throw new UsernameNotFoundException(email);
	        }
	       
	       
	       return principal;
	    }

}
