package org.sree.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.sree.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {
	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("username","user10"));
		
			
		List<UserDetails> users = (List<UserDetails>)criteria.list();
		session.getTransaction().commit();
		session.close();
	
		for (UserDetails user: users)
			System.out.println(user.getUsername());
				
	} 	
	

}
