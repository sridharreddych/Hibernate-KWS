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
		UserDetails user2 = new UserDetails();
	//	user2.setUsername("Second User");
		
		Address addr = new Address();
		addr.setCity("hyd");
		addr.setPincode("508213");
		addr.setState("karnataka");
		addr.setStreet("Madiwla");
		
		user.setHomeAddress(addr);
		
		Address addr2 = new Address();
		addr2.setCity("sec");
		addr2.setPincode("508214");
		addr2.setState("karnataka");
		addr2.setStreet("Electronic City");
		
		user.setOfficeAddress(addr2);
		
		/*user.setJoinedDate(new Date());
		user.setAddress("First Users Address");
		user.setDescription("first user description");*/
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		//session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session= sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is "+ user.getUsername());
	
		
	} 	
	

}
