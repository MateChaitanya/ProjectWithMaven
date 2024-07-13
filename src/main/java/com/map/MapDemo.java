package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java?");

        // Creating answer
        Answer answer1 = new Answer();
        answer1.setAnswerId(343);
        answer1.setAnswer("Java is a programming language");
        answer1.setQuestion(q1);
        q1.setAnswer(answer1);

        // Creating another question
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is collection framework?");

        // Creating another answer
        Answer answer2 = new Answer();
        answer2.setAnswerId(344);
        answer2.setAnswer("API to work with objects in java");
        answer2.setQuestion(q2);
        q2.setAnswer(answer2);

        // Session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Save questions first
        session.save(q1);
        session.save(q2);

        // Save answers
        session.save(answer1);
        session.save(answer2);

        tx.commit();
        session.close();

        factory.close();
    }
}
