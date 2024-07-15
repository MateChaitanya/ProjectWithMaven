package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class MapDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating the first question
        Question q1 = new Question();
        q1.setQuestion("What is Java?");
        
        // Creating the first answer
        Answer answer1 = new Answer("Java is a programming language");
        answer1.setQuestion(q1);
        q1.setAnswers(Arrays.asList(answer1));

        // Creating the second question
        Question q2 = new Question();
        q2.setQuestion("What is the collection framework?");
        
        // Creating the second answer
        Answer answer2 = new Answer("API to work with objects in Java");
        answer2.setQuestion(q2);
        q2.setAnswers(Arrays.asList(answer2));

        // Session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Save questions (this will cascade to answers)
        session.save(q1);
        session.save(q2);

        tx.commit();
        session.close();

        factory.close();
    }
}
