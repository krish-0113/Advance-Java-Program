package com.krishna;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String args[]){
      ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
      Student std = (Student) context.getBean("stdId");
        System.out.println(std);
    }
}
