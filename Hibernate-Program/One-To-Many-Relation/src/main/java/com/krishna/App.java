package com.krishna;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String args[]) {
        Transaction transaction = null;
        try {
            // Create Question object
            Question1 question = new Question1();
            question.setQuestion1s("What is Java?");

            // Creating Answer objects
            Answer1 answer1 = new Answer1();
            answer1.setAnswer1_id(111);
            answer1.setAnswer1("Java is a programming language with strong object-oriented features.");
            answer1.setQuestion1(question);

            Answer1 answer2 = new Answer1();
            answer2.setAnswer1_id(112);
            answer2.setAnswer1("Java is both compiled and interpreted, using JVM architecture.");
            answer2.setQuestion1(question);

            Answer1 answer3 = new Answer1();
            answer3.setAnswer1_id(113);
            answer3.setAnswer1("Java enables cross-platform enterprise application development with robust libraries.");
            answer3.setQuestion1(question);

            // Adding Answers to List
            List<Answer1> list = new ArrayList<>();
            list.add(answer1);
            list.add(answer2);
            list.add(answer3);
            question.setAnswer1(list);

            // Hibernate Configuration
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(Question1.class);
            cfg.addAnnotatedClass(Answer1.class);

            // Creating SessionFactory & Session
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Saving Only Question (CascadeType.ALL will save answers automatically)
            session.persist(question);

            transaction.commit();
            System.out.println("Data saved successfully!");

            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
