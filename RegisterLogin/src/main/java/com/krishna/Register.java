package com.krishna;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

@WebServlet("/regForm")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String myname = req.getParameter("name1");
        String myemail = req.getParameter("email1");
        String mypass = req.getParameter("pass1");
        String mygender = req.getParameter("gender1");
        String mycity = req.getParameter("city1");

        // Validate inputs
        if (myname == null || myname.trim().isEmpty() ||
                myemail == null || myemail.trim().isEmpty() ||
                mypass == null || mypass.trim().isEmpty() ||
                mygender == null || mygender.trim().isEmpty() ||
                mycity == null || mycity.trim().isEmpty() || "Select City".equals(mycity)) {

            out.print("<h3 style='color:red;'>All fields are required!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);
            return;
        }

        // Validate email format
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(emailRegex, myemail)) {
            out.print("<h3 style='color:red;'>Invalid email format!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);
            return;
        }

        // Validate password length
        if (mypass.length() < 6) {
            out.print("<h3 style='color:red;'>Password must be at least 6 characters long!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg_db", "root", "Rathod@2003");

            PreparedStatement ps = con.prepareStatement("INSERT INTO register(name, email, Passwoerd, gender, city) VALUES(?,?,?,?,?)");
            ps.setString(1, myname);
            ps.setString(2, myemail);
            ps.setString(3, mypass);
            ps.setString(4, mygender);
            ps.setString(5, mycity);

            int count = ps.executeUpdate();

            if (count > 0) {
                out.print("<h3 style='color:green;'>User Registered Successfully</h3>");
            } else {
                out.print("<h3 style='color:red;'>User Not Registered due to an error</h3>");
            }

            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h3 style='color:red;'>" + e.getMessage() + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);
        }
    }
}
