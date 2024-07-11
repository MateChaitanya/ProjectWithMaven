 package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // Load the configuration and build the session factory
        Configuration cfg  = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Create a student object 
        //create a student object
        Student st = new Student();
        st.setId(104);
        st.setName("Sameer");
        st.setCity("Pune");
        System.out.println(st);
        
        // Open a new session
        Session session = factory.openSession();
        
        // Begin transaction
        Transaction tx = session.beginTransaction();
        
        // Save the student object
        session.save(st);
        
        // Commit the transaction
        tx.commit();
        
        // Close the session
        session.close();
        
        // Optional: Check if the factory is closed
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
    }
}
