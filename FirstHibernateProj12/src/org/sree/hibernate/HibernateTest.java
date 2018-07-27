package org.sree.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sree.dto.Address;
import org.sree.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
	
		UserDetails user = new UserDetails();
		user.setUsername("First User");
		
		Address addr1 = new Address();
		addr1.setCity("hyd");
		addr1.setPincode("508213");
		addr1.setState("karnataka");
		addr1.setStreet("Madiwla");
		
				
		Address addr2 = new Address();
		addr2.setCity("sec");
		addr2.setPincode("508214");
		addr2.setState("karnataka");
		addr2.setStreet("Electronic City");
		
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		
		user=null;
		session= sessionFactory.openSession();
		user = (UserDetails)session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAddresses().size());
		
		
		
	
		
	} 	
	

}
