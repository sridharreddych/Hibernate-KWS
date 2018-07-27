package org.sree.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sree.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
	
		UserDetails user = new UserDetails();
		user.setUserId(1);  
		user.setUsername("First User");
		user.setJoinedDate(new Date());
		user.setAddress("First Users Address");
		user.setDescription("first user description");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session= sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is "+ user.getUsername());
	
		
	} 	
	

}
