package com.krishna;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String args[]) {
        // Creating Question Object
        Question question = new Question();
        question.setQuestion_id(12);
        question.setQuestions("What is Java?");

        // Creating Answer Object
        Answer answer = new Answer();
        answer.setAnswer_id(111);
        answer.setAnswer("Java is a programming language.");

        // Establishing relationship
        question.setAnswer(answer);  // This sets answer.question = question as well

        // Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Question.class);
        cfg.addAnnotatedClass(Answer.class);

        // Creating SessionFactory & Session
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Saving Objects (Only Question)
        session.save(question); // Answer is automatically saved due to CascadeType.ALL

        // Committing Transaction
        transaction.commit();

        System.out.println("Data saved successfully!");
    }
}
