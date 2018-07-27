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
	
				
		UserDetails user = (UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		//user.setUsername("Updated user name after session close");
		user.setUsername("Changed Name");
		
		session= sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		//user.setUsername("Change after update");
		session.getTransaction().commit();
		session.close();
				
	} 	
	

}
