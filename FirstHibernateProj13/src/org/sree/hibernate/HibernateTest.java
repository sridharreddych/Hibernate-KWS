package org.sree.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sree.dto.Address;
import org.sree.dto.UserDetails;
import org.sree.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
	
		UserDetails user = new UserDetails();
		user.setUsername("First User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		user.setVehicle(vehicle);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user); 
		session.save(vehicle);
		session.getTransaction().commit();
		
		session.close();
		
				
	} 	
	

}
