package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String args[]){
        // Load Spring Container
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");


        // Retrieve a bean from the container
         Student std = ( Student) context.getBean("student");
         std.display();

//         System.out.println(".........................................................");
//
//        Student std2 = ( Student) context.getBean("stdId2");
//        std2.display();
    }

}
