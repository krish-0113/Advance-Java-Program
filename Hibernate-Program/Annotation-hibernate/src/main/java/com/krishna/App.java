package com.krishna;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String args[]) throws IOException {
        System.out.println("Project Started......");

        // Creating Address object
        Address add = new Address();
        add.setStreet("kolgaon");
        add.setCity("Nanded");
        add.setOpen(true);
        add.setX(122.21);
        add.setAddedDate(new Date());

        // Reading image
//        File file = new File("src/main/java/photo.jpg");
//        if (file.exists()) { // Ensure file exists
//            FileInputStream fis = new FileInputStream(file);
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//
//            while ((bytesRead = fis.read(buffer)) != -1) {
//                bos.write(buffer, 0, bytesRead);
//            }
//
//            byte[] imageData = bos.toByteArray();
//            fis.close();
//            bos.close();
//            add.setImage(imageData);
//        } else {
//            System.out.println("Image file not found!");
//        }

        // Creating Student object
        Student std = new Student();
        std.setRollno(101);
        std.setName("Krish");
        std.setEmail("Krish@gmail.com");
        std.setPassword("krishna@123");
        std.setAddress(add); // Set embedded Address

        // Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(std); // Saving student with embedded address

        // Retrieve student
        Student retrievedData = session.get(Student.class, 1);
        if (retrievedData != null) {
            System.out.println("User Found: " + retrievedData.getName() + ", Email: " + retrievedData.getEmail());
        } else {
            System.out.println("User not found!");
        }

        transaction.commit();

    }
}
