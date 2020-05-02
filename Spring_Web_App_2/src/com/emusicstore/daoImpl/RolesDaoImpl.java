package com.emusicstore.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.emusicstore.dao.RolesDAO;
import com.emusicstore.pojo.Product;
import com.emusicstore.pojo.Roles;

@Repository
@Transactional
public class RolesDaoImpl implements RolesDAO {

	private static final Logger logger = Logger.getLogger(Roles.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addRole(Roles role) {
		Session session = sessionFactory.getCurrentSession();	
		session.saveOrUpdate(role);
		session.getTransaction().commit();
		session.close();		
		
	}

	@Override
	public void delteRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Roles userRole = (Roles)session.get(Roles.class,id);
		session.delete(userRole);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Roles> listRoles() {
		Session session = sessionFactory.getCurrentSession();
		List<Roles> roles = session.createQuery("From Roles").list();
		logger.debug("Query List Executed"+session.createQuery("From Roles").list());
		session.flush();


		return roles;
	}

	@Override
	public void updateRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Roles role = (Roles)session.get(Roles.class,id);
		session.saveOrUpdate(role);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Roles getRole(int id) {
        Session session = sessionFactory.getCurrentSession();
		Roles role = (Roles)session.get(Roles.class,id);
		session.flush();		
		
		return role;
	}

}
