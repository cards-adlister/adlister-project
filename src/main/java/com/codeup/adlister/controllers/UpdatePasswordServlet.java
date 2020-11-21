package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdatePasswordServlet", urlPatterns = "/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
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
        String newPassword = request.getParameter("password");
        String confirmNewPassword = request.getParameter("confirm_password");
        //validate input
        boolean hasInputErrors = false;

        //List of possible errors & responses
        ArrayList<String> listOfErrors = new ArrayList<>();

        //check for error
        if(!newPassword.equals(confirmNewPassword)){
            String passwordsNotMatching = "Password and confirm password do not match.";
            listOfErrors.add(passwordsNotMatching);
            hasInputErrors = true;
        } else if (newPassword.isEmpty() || confirmNewPassword.isEmpty()){
            String passwordFieldEmpty = "Password or Confirm Password field empty.";
            listOfErrors.add(passwordFieldEmpty);
            hasInputErrors = true;
        }

        if(hasInputErrors){
            request.setAttribute("listOfErrors", listOfErrors);
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
        } else {
            newPassword = Password.hash(newPassword);
            DaoFactory.getUsersDao().updatePassword(newPassword, userId);
            response.sendRedirect("/login");
        }
    }
}
