package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.ArrayList;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        HttpSession session = request.getSession(true);
        session.getAttributeNames();

        boolean hasInputErrors = false;

        ArrayList<String> listOfErrors = new ArrayList<>();
        if(username.isEmpty()){
            String usernameIsEmpty = "You must enter an username.";
            listOfErrors.add(usernameIsEmpty);
            hasInputErrors = true;
        }
        if(email.isEmpty()){
            String emailIsEmpty = "You must enter a valid email.";
            listOfErrors.add(emailIsEmpty);
            hasInputErrors = true;
        }
        if(password.isEmpty()){
            String passwordIsEmpty = "You must enter a password.";
            listOfErrors.add(passwordIsEmpty);
            hasInputErrors = true;
        }
        //check password and confirmation match

        if (!password.equals(passwordConfirmation)){
            String passwordDontMatch = "Your passwords don't match.";
            listOfErrors.add(passwordDontMatch);
            hasInputErrors = true;
        }

        //check for duplicate username
        boolean isDuplicateUsername = true;
        if (DaoFactory.getUsersDao().findByUsername(username) == null){
            isDuplicateUsername = false;
        }
        if(isDuplicateUsername){
            String isDuplicateUser = "That username is already in use.";
            listOfErrors.add(isDuplicateUser);
            hasInputErrors = true;
        }

        //check for duplicate email
        boolean isDuplicateEmail = true;
        if (DaoFactory.getUsersDao().findByEmail(email) == null){
            isDuplicateEmail = false;
        }
        if(isDuplicateEmail){
            String emailIsDuplicate = "An account with that email address already exists. Please login.";
            listOfErrors.add(emailIsDuplicate);
            hasInputErrors = true;
        }

        if(hasInputErrors){
            request.getSession().setAttribute("listOfErrors", listOfErrors);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            // create and save a new user
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }

    }
}
