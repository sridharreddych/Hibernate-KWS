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
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
	
		for(int i=1; i<11; i++) {
			UserDetails user = new UserDetails(); 
			user.setUsername("user"+i);
			session.save(user);
		}
		
		session.getTransaction().commit();
		
		session.close();
		
				
	} 	
	

}
