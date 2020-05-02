package com.emusicstore.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.ItemDAO;
import com.emusicstore.pojo.Item;

@Repository
@Transactional
public class ItemDAOImp implements ItemDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addItem(Item item){
		Session session = sessionFactory.openSession();
		session.save(item);
		session.flush();
	}
	
}
