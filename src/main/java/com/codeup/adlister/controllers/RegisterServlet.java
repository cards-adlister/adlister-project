package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
//        boolean inputHasErrors = username.isEmpty()
//            || email.isEmpty()
//            || password.isEmpty()
//            || (! password.equals(passwordConfirmation));
//
//        if (inputHasErrors) {
//            response.sendRedirect("/register");
//            return;
//        }
        //check password and confirmation match
        boolean passwordConfirmNotMatch = !password.equals(passwordConfirmation);
        if (passwordConfirmNotMatch){
            request.getSession().setAttribute("pwmessage", "Password and Password Confirmation do not match.");
            response.sendRedirect("/register");
            return;
        }

        //check for duplicate username
        boolean isDuplicateUsername = true;
        if (DaoFactory.getUsersDao().findByUsername(username) == null){
            isDuplicateUsername = false;
        }
        if(isDuplicateUsername){
            request.getSession().setAttribute("message", "Username is already taken.");
            response.sendRedirect("/register");
            return;
        }

        //check for duplicate email
        boolean isDuplicateEmail = true;
        if (DaoFactory.getUsersDao().findByEmail(email) == null){
            isDuplicateEmail = false;
        }
        if(isDuplicateEmail){
            request.getSession().setAttribute("emessage", "An account with that email already exists. Please login.");
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
