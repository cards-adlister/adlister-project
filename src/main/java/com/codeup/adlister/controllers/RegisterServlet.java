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
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

<<<<<<< HEAD
        //List of possible errors & responses
        ArrayList<String> listOfErrors = new ArrayList<>();

        //check for errors
        if(username.isEmpty()){
            String usernameIsEmpty = "You must enter an username.";
            listOfErrors.add(usernameIsEmpty);
            hasInputErrors = true;
        } else {
            User user = DaoFactory.getUsersDao().findByUsername(username);
            if(user != null){
                listOfErrors.add("That username is already in use.");
                hasInputErrors = true;
            }
        }
        if(email.isEmpty()){
            String emailIsEmpty = "You must enter a valid email.";
            listOfErrors.add(emailIsEmpty);
            hasInputErrors = true;
        } else  {
            User user = DaoFactory.getUsersDao().findByEmail(email);
            if (user != null){
                listOfErrors.add("An account with that email address already exists. Please login.");
                hasInputErrors = true;
            }
        }
        if(password.isEmpty()){
            String passwordIsEmpty = "You must enter a password.";
            listOfErrors.add(passwordIsEmpty);
            hasInputErrors = true;
        }

        if (!password.equals(passwordConfirmation)){
            String passwordDontMatch = "Your passwords don't match.";
            listOfErrors.add(passwordDontMatch);
            hasInputErrors = true;
        }

        if(hasInputErrors){
            request.setAttribute("listOfErrors", listOfErrors);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            // create and save a new user
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
=======
        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
>>>>>>> fc613a62857fe205549cf62f1a48c67d349cadc5
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
