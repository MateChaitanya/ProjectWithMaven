package com.tut;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class FetchDemo {

	public static void main(String[]args) {
		//get , load 
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory factory = cfg.buildSessionFactory();
		 Session session = factory.openSession();
		 
		 //get-student:106
		 Student student = (Student)session.get(Student.class,106);
		 System.out.println(student);
		 
		 Address ad=(Address)session.get(Address.class, 2);
		 System.out.println(ad.getStreet());
		 
		 
		 
		 session.close();
		 factory.close();
		 
		
	}
}
