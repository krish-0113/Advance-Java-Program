package com.krishna;



public class Student {
    private String name;
    private int rollNo;
    private String email;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display(){
        System.out.println("Name" + name);
        System.out.println("Roll Number " + rollNo);
        System.out.println("Name" + email);
    }
}
