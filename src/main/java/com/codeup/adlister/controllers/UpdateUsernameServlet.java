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

@WebServlet(name = "UpdateUsernameServlet", urlPatterns = "/updateUsername")
public class UpdateUsernameServlet extends HttpServlet {

    User profile;
    long profileId;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedProfile = request.getPathInfo();
        System.out.println(selectedProfile);
        try {
            profileId = Long.parseLong(selectedProfile.substring(1));
            System.out.println(profileId);
            profile = DaoFactory.getUsersDao().findById(profileId);
            request.setAttribute("user", profile);
            System.out.println(profile);
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request,response);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newUsername = request.getParameter("username");
        String userId = request.getParameter("userId");
        //validate input
        boolean hasInputErrors = false;

//        List of possible errors & responses
        ArrayList<String> listOfErrors = new ArrayList<>();

//        check for error
        if(newUsername.isEmpty()){
            String usernameIsEmpty = "You must enter an username.";
            listOfErrors.add(usernameIsEmpty);
            hasInputErrors = true;
        } else {
            User user = DaoFactory.getUsersDao().findByUsername(newUsername);
            if(user != null && !user.getUsername().equals(profile.getUsername())){
                listOfErrors.add("That username is already in use by another account.");
                hasInputErrors = true;
            }
        }
        if(hasInputErrors){
            request.setAttribute("listOfErrors", listOfErrors);
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
        } else {
            DaoFactory.getUsersDao().updateUsername(newUsername, userId);
            response.sendRedirect("/login");
        }
    }
}
