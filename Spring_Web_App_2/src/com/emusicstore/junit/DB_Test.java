package com.emusicstore.junit;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.RolesDAO;
import com.emusicstore.dao.CustomerDao;
import com.emusicstore.daoImpl.RolesDaoImpl;
import com.emusicstore.daoImpl.userDaoImpl;
import com.emusicstore.pojo.Admin;
import com.emusicstore.pojo.Customer;
import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.Roles;
import com.emusicstore.pojo.ShippingAddress;
import com.emusicstore.service.CustomerService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-security-test.xml","classpath:spring-servlet-test.xml"})
public class DB_Test {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CustomerService customerService;
	@Autowired
	RolesDAO rolesDao;


	//@Test
	//@Transactional
	public void createRoles() {
		Roles role = new Roles("USER_ROLE");
		rolesDao.addRole(role);
		Roles role = new Roles("ADMIN_ROLE");
		rolesDao.addRole(role);
	}
	
	@Test
	public void TestCustomer(){		
		ShippingAddress sa = new ShippingAddress("a","b","c","d","e");
		Roles role = rolesDao.getRole(1);
		Customer customer = new Customer("customeremail", "Second", "customeremail", "ADMIN",sa,role);
		customerService.addCustomer(customer);
	}

	@Test
	public void TestAdmin(){
		ShippingAddress sa = new ShippingAddress("a","b","c","d","e");
		Roles role = rolesDao.getRole(2);
		Customer customer = new Customer("ADMIN", "Second", "ADMIN", "ADMIN",sa,role);
		customerService.addCustomer(customer);
		
	}


	//@Test
	//@Transactional
	public void getcustomer() {
		Session session =  sessionFactory.getCurrentSession();
		String email="customeremail";
		String sql = "FROM Customer C WHERE C.email ='"+email+"'";
		org.hibernate.Query query =  session.createQuery(sql);
		System.out.print("!!!"+query);
		Customer customer=(Customer) query.uniqueResult();
		System.out.print("Customer name is"+customer.getFirstName().toString());
	}
	
	
	

}
