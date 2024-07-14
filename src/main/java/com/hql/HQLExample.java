package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query; // Correct import

import com.tut.Student;

public class HQLExample {

	public static void main(String[]args) {
		Configuration cfg  = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session s = factory.openSession();
        
        // HQL
        // Syntax
        
        String query = "from students where city = 'ABC'";
        Query q = s.createQuery(query); // Ensure this is correctly parameterized
        
        // single result
        // multiple result
        
        List<Student> list = q.list(); // Correct the variable name here
        for(Student student:list) { // Ensure the loop uses the corrected variable name
            System.out.println(student.getName());
        }
        
        s.close();
        factory.close();
	}
}
