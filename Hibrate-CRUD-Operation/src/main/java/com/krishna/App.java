package com.krishna;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Step 1: Create Hibernate Configuration & Build SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Load Hibernate config file

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Step 2: Open a Session
        Session session = sessionFactory.openSession();

        // Step 3: Start a Transaction
        Transaction transaction = session.beginTransaction();

        // Step 4: Create User Objects & Set Data
        User user1 = new User();
        user1.setName("Sachin");
        user1.setEmail("Sachin@example.com");
        user1.setPassword("password123");
        user1.setCity("Nanded");

        User user2 = new User();
        user2.setName("Cnu");
        user2.setEmail("cnu@example.com");
        user2.setPassword("password123");
        user2.setCity("Bhokar");

        // ................................Insert Operation ..........................................
        try {
            session.save(user1);
            session.save(user2);
            transaction.commit();
            System.out.println("Users inserted successfully!");

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // ................................Select Operation ..........................................
        try {
            // Reopen session for fetching data
            session = sessionFactory.openSession();
            User retrievedUser = session.get(User.class, 1); // Fetch user with ID 1
            if (retrievedUser != null) {
                System.out.println("User Found: " + retrievedUser.getName() + ", Email: " + retrievedUser.getEmail());
            } else {
                System.out.println("User not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ................................Update Operation ..........................................
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User updateUser = session.get(User.class, 1);
            if (updateUser != null) {
                updateUser.setCity("Kolgaon"); // Updating city
                session.update(updateUser);
                transaction.commit();
                System.out.println("User updated successfully!");
            } else {
                System.out.println("User not found for update!");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // ................................Delete Operation ..........................................
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User deleteUser = session.get(User.class, 2); // Fetch user with ID 2
            if (deleteUser != null) {
                session.delete(deleteUser);
                transaction.commit();
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found for deletion!");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // Close session & factory
        session.close();
        sessionFactory.close();
    }
}
