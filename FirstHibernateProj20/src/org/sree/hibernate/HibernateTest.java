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
	
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike steering Handle");
		

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Prosche");
		car.setSteeringWheel("Prosche steering Wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(vehicle); 
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		
		session.close();
		
				
	} 	
	

}
