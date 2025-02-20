package com.krishna;

public class Student {
    private int rollno;
    private String name;
    private Address address; // This will be injected


    // using constructor dependacncy

    public Student(int rollno,String name, Address address){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setRollno(int rollno) {
//        this.rollno = rollno;
//    }

    @Override
    public String toString() {
        return "Student Info [Roll No = " + rollno + ", Name = " + name + ", Address = " + address + "]";
    }
}
