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
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		vehicle.getUserList().add(user);
		vehicle2.getUserList().add(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user); 
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		
		session.close();
		
				
	} 	
	

}
