package com.krishna;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/loginForm")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String myemail = req.getParameter("email1");
        String mypass = req.getParameter("pass1");

        // Validate inputs
        if (myemail == null || myemail.trim().isEmpty() || mypass == null || mypass.trim().isEmpty()) {
            out.print("<h3 style='color:red;'>All fields are required!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.include(req, resp);
            return;
        }

        try {
            // JDBC code to check the user credentials
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg_db", "root", "Rathod@2003");

            // Prepare statement to check credentials in the database
            PreparedStatement ps = con.prepareStatement("SELECT * FROM register WHERE Email=? AND Passwoerd =?");
            ps.setString(1, myemail);
            ps.setString(2, mypass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // User found, create a session and redirect to profile.jsp
                HttpSession session = req.getSession();
                session.setAttribute("session_name", rs.getString("Name"));

                // Use RequestDispatcher to forward the request to profile.jsp
                RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
                rd.forward(req, resp); // Use forward here to move to the profile page
            } else {
                // Invalid credentials
                out.print("<h3 style='color:red;'>Invalid Email or Password</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                rd.include(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.setContentType("text/html");
            out.print("<h3 style='color:red;'>" + e.getMessage() + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.include(req, resp);
        }
    }
}
