package com.emusicstore.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.dao.RolesDAO;
import com.emusicstore.daoImpl.CustomerDaoImp;
import com.emusicstore.pojo.Customer;
import com.emusicstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	public static final Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerDao customerdao;
	@Autowired
	RolesDAO rolesDao;

	@Override
	public List<Customer> getCustomerList() {
		return customerdao.listCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		
		logger.getLogger("CustomerServiceImpl addCustomer: adding customer "+customer.getFirstName());
		customer.setRole(rolesDao.getRole(1));
		customerdao.addCustomer(customer);

	}

	@Override
	public void editCustomer(int id) {
		customerdao.updateCustomer(id);

	}

	@Override
	public void updateCustomer(int id) {
		customerdao.updateCustomer(id);

	}

	@Override
	public Customer getCustomer(String email) {
		logger.getLogger("CustomerServiceImpl getCustomer: get customer by email: "+email);
		Customer customer =customerdao.getCustomer(email);
		return customer;

	}
	
}
