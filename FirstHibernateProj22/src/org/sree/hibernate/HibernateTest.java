package org.sree.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sree.dto.Address;
import org.sree.dto.FourWheeler;
import org.sree.dto.TwoWheeler;
import org.sree.dto.UserDetails;
import org.sree.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
	
		
		UserDetails user =new UserDetails();
		user.setUsername("Test User");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
	
				
		session.save(user);
		
		user.setUsername("Updated user");
		user.setUsername("Updated user Again");
		
		session.getTransaction().commit();
		
		session.close();
		user.setUsername("Updated user After session is closed");
		
		
		
				
	} 	
	

}
