package com.emusicstore.junit;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.pojo.Customer;
import com.emusicstore.pojo.Roles;
import com.emusicstore.service.CustomerService;
import com.emusicstore.serviceImpl.MyUserPrincipalimpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-security-test.xml","classpath:spring-servlet-test.xml"})
public class CustomerServiceIT {


	public static final Logger logger = Logger.getLogger(CustomerServiceIT.class);
	
	@Autowired
	CustomerDao customerDao;
	
	@Test
	public void LoginService() {
		String email="customeremail";
		logger.info("Customer DAO Email:" +email);
		Customer customer = customerDao.getCustomer(email);
		logger.info("Customer DAO Email:" +customer.getEmail());		
		Roles role = customer.getRole();
		logger.info("Customer DAO Role:" + role.getRoles());

	}
}
