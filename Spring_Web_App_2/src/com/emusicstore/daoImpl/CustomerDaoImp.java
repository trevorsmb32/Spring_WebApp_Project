package com.emusicstore.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.pojo.Customer;

@Repository
@Transactional
public class CustomerDaoImp implements CustomerDao {

	private static final Logger logger = Logger.getLogger(CustomerDaoImp.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();;
		session.saveOrUpdate(customer);
        session.flush();
	}

	@Override
	public void updateCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class,id);
		session.saveOrUpdate(customer);
		session.flush();

	}

	@Override
	public Customer getCustomer(String email) {
		Session session =  sessionFactory.getCurrentSession();
		String sql = "FROM Customer C WHERE C.email ='"+email+"'";
		org.hibernate.Query query =  session.createQuery(sql);
		Customer customer=(Customer) query.uniqueResult();
		session.flush();

		return (Customer) query.uniqueResult();

	}

	@Override
	public List<Customer> listCustomers() {
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = session.createSQLQuery("From Customer").list();
		session.flush();

		return customers;
	}

}
