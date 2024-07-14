package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;
import com.tut.Certificate;

public class StateDemo {

	public static void main(String[]args) {
		//Practical of Hibernate Objects States
		//Transient
		//Persistent
		//Detached
		//Removed 
		System.out.println("Example : ");
		SessionFactory  f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating Student Object 
		
		Student student = new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certificate("Java Hibernate Course","2 month "));
		
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		
		tx.commit();
		
		//student:Transient state
		
		f.close();
	}
}
