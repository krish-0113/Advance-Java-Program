package com.krishna;

public class Address {
    private String houseno;
    private String city;
    private int pincode;  // Ensure this is int

    // Constructor
    public Address(String houseno, String city, int pincode) {
        this.houseno = houseno;
        this.city = city;
        this.pincode = pincode;
    }



//    // Getters and setters dependancy
//    public void setHouseno(String houseno) {
//        this.houseno = houseno;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setPincode(String pincode) {
//        this.pincode = pincode;
//    }

    @Override
    public String toString() {
        return "Address [houseno=" + houseno + ", city=" + city + ", pincode=" + pincode + "]";
    }
}
