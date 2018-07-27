package org.sree.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sree.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {
	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails exampleUser = new UserDetails();
		//exampleUser.setUserId(5);
		exampleUser.setUsername("user1%");
		
		Example example = Example.create(exampleUser).enableLike();
		
		Criteria criteria = session.createCriteria(UserDetails.class)
							.add(example);
							    	
		List<UserDetails> users = (List<UserDetails>)criteria.list();
		session.getTransaction().commit();
		session.close();
	
		for (UserDetails user: users)
			System.out.println(user.getUsername());
				
	} 	
	

}
