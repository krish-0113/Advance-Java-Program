package com.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring application context correctly
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

        // Retrieve the bean by its method name ('stdId1')
        Student std =  (Student) context.getBean("studOj1");
        std.display();

        System.out.println(".................................");

        Student std2 = (Student) context.getBean("studOj2");
        std2.display();
    }
}
