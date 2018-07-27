package org.sree.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sree.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {
	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
	
		Query query = session.createQuery(" from UserDetails user where user.userId = 1"); 
		query.setCacheable(true);
		List users = query.list();
		
		session.getTransaction().commit();
		session.close();
	
		Session session2= sessionFactory.openSession();
		session2.beginTransaction();
	
		Query query2 = session2.createQuery(" from UserDetails user where user.userId = 1"); 
		query2.setCacheable(true);
		users = query2.list();
		
		
		session2.getTransaction().commit();
		session2.close();
	
				
	} 	
	

}
