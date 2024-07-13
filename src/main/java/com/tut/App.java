 package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException
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
        
        //Creating object of  address class 
        Address ad = new Address();
        ad.setStreet("Street1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date(0));
        ad.setX(1.234);
        
        //Reading image
        FileInputStream fis = new FileInputStream("src/main/java/pic.jpeg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        // Open a new session
        Session session = factory.openSession();
        
        // Begin transaction
        Transaction tx = session.beginTransaction();
        
        // Save the student object
        session.save(st);
        
        session.save(ad);
        
        // Commit the transaction
        tx.commit();
        
        // Close the session
        session.close();
        System.out.println("DONE...");
        
        // Optional: Check if the factory is closed
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
    }
}
