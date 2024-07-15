package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Question;
import com.map.Answer;

public class CascadeExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Question question = new Question();
        question.setQuestion("What is Cascading?");

        Answer answer1 = new Answer("In Hibernate, cascading is an important concept.");
        Answer answer2 = new Answer("Second Answer");
        Answer answer3 = new Answer("Third Answer");

        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);

        question.setAnswers(answers);

        Transaction tx = session.beginTransaction();
        session.save(question);
        tx.commit();

        session.close();
        factory.close();
    }
}
