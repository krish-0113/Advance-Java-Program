package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Defines this class as a Spring configuration
public class SpringConfigFile {

    @Bean("studOj1")
    public Student createStudentObj1() {
        Student std = new Student();
        std.setName("Krishna");
        std.setEmail("krish@gmail.com");
        std.setRollNo(132);
     return std;
    }

    @Bean("studOj2")
    public Student createStudentObj12() {
        Student std = new Student();
        std.setName("Sachin");
        std.setEmail("Sachin@gmail.com");
        std.setRollNo(122);
        return std;
    }
}
