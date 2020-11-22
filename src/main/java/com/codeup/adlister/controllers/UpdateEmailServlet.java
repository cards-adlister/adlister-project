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

@WebServlet(name = "UpdateEmailServlet", urlPatterns = "/updateEmail")
public class UpdateEmailServlet extends HttpServlet {
    User profile;
    long profileId;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedUsername = request.getPathInfo();
        try {
            profileId = Long.parseLong(selectedUsername.substring(1));
            profile = DaoFactory.getUsersDao().findById(profileId);
            request.setAttribute("user", profile);
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request,response);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String newEmail = request.getParameter("email");
        //validate input
        boolean hasInputErrors = false;

        //List of possible errors & responses
        ArrayList<String> listOfErrors = new ArrayList<>();

        //check for error
        if(newEmail.isEmpty()){
            String emailIsEmpty = "You must enter a valid email.";
            listOfErrors.add(emailIsEmpty);
            hasInputErrors = true;
        } else {
            User user = DaoFactory.getUsersDao().findByUsername(newEmail);
            if(user != null && !user.getEmail().equals(profile.getEmail())){
                listOfErrors.add("That email is already in use by another account.");
                hasInputErrors = true;
            }
        }
        if(hasInputErrors){
            request.setAttribute("listOfErrors", listOfErrors);
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
        } else {
            DaoFactory.getUsersDao().updateEmail(newEmail, userId);
            response.sendRedirect("/login");
        }
    }
}
