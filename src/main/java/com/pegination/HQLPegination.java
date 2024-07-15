package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPegination {

	public static void main(String[]args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query<Student> query = s.createQuery("from Student");
		
		//Implementing pegination using hibernate 
		
		query.setFirstResult(0);   //Starting index
		query.setMaxResults(2);     // ending index 
		
		
		List<Student>list = query.list();
		
		for(Student st : list)
		{
			System.out.println(st.getId()+ "." + st.getName()+":" + st.getCity());
		}
		
		s.close();
		
		
		
		
		factory.close();
	}
}