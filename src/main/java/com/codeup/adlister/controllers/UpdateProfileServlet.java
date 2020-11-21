package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = "/updateProfile/*")
public class UpdateProfileServlet extends HttpServlet {
    User profile;
    long profileId;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedProfile = request.getPathInfo();
        try {
            profileId = Long.parseLong(selectedProfile.substring(1));
            profile = DaoFactory.getUsersDao().findById(profileId);
            request.setAttribute("user", profile);
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request,response);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        //validate input
        boolean hasInputErrors = false;

        //List of possible errors & responses
        ArrayList<String> listOfErrors = new ArrayList<>();

        //check for error
        if(username.isEmpty()){
            String usernameIsEmpty = "You must enter an username.";
            listOfErrors.add(usernameIsEmpty);
            hasInputErrors = true;
        } else {
            User user = DaoFactory.getUsersDao().findByUsername(username);
            if(user != null && !user.getUsername().equals(profile.getUsername())){
                listOfErrors.add("That username is already in use by another account.");
                hasInputErrors = true;
            }
        }
        if(email.isEmpty()){
            String emailIsEmpty = "You must enter a valid email.";
            listOfErrors.add(emailIsEmpty);
            hasInputErrors = true;
        } else  {
            User user = DaoFactory.getUsersDao().findByEmail(email);
            if (user != null && !user.getEmail().equals(profile.getEmail())){
                listOfErrors.add("Another account with that email address already exists. Please login.");
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
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
        } else {
            profile.setUsername(username);
            profile.setEmail(email);
            profile.setPassword(password);
            profile.setId(profileId);
            DaoFactory.getUsersDao().updateUser(profile);
            response.sendRedirect("/login");
        }
    }
}
