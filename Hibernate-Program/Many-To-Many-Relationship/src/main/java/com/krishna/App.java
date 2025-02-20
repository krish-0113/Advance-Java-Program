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
            Project prt1 = new Project();
//            prt1.setPid(9);
            prt1.setProjectName("E-Learning Platform");

            Project prt2 = new Project();
//            prt2.setPid(10);
            prt2.setProjectName("website developmenet");

            // Creating objects
            Employees emp1 = new Employees();
//            emp1.setEmpid(34);
            emp1.setEmpName("Krishna");

            Employees emp2= new Employees();
            emp2.setEmpName("Sachin");

            List<Employees> list1 = new ArrayList<>();
            List<Project> list2 = new ArrayList<>();

            list1.add(emp1);
            list1.add(emp2);

            list2.add(prt1);
            list2.add(prt2);

            emp1.setProjects(list2);
            prt2.setEmployees(list1);


            // Hibernate Configuration
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(Project.class);
            cfg.addAnnotatedClass(Employees.class);

            // Creating SessionFactory & Session
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(emp1);
            session.persist(emp2);
            session.persist(prt1);
            session.persist(prt2);

            transaction.commit();
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
