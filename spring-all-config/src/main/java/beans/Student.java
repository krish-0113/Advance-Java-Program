package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("Krishna")
    private String name;
    @Value("102")
    private int rollNo;
    @Value("krishna@gmail.com")
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
        System.out.println("Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("Email : " + email);
    }
}
