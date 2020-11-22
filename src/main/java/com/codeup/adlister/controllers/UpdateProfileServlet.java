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
//        String username_update = request.getParameter("username");
//        String email_update = request.getParameter("email");
//        String password_update = request.getParameter("password");
//        String password_update_confirm = request.getParameter("confirm_password");
//
//        //validate input
//        boolean hasInputErrors = false;
//
//        //List of possible errors & responses
//        ArrayList<String> listOfErrors = new ArrayList<>();
//
//        //check for error
//        if(username_update.isEmpty()){
//            String usernameIsEmpty = "You must enter an username.";
//            listOfErrors.add(usernameIsEmpty);
//            hasInputErrors = true;
//        } else {
//            User user = DaoFactory.getUsersDao().findByUsername(username_update);
//            if(user != null && !user.getUsername().equals(profile.getUsername())){
//                listOfErrors.add("That username is already in use by another account.");
//                hasInputErrors = true;
//            }
//        }
//        if(email_update.isEmpty()){
//            String emailIsEmpty = "You must enter a valid email.";
//            listOfErrors.add(emailIsEmpty);
//            hasInputErrors = true;
//        } else  {
//            User user = DaoFactory.getUsersDao().findByEmail(email_update);
//            if (user != null && !user.getEmail().equals(profile.getEmail())){
//                listOfErrors.add("Another account with that email address already exists. Please login.");
//                hasInputErrors = true;
//            }
//        }
//        if(password_update.isEmpty()){
//            String passwordIsEmpty = "You must enter a password.";
//            listOfErrors.add(passwordIsEmpty);
//            hasInputErrors = true;
//        }
//
//        if (!password_update.equals(password_update_confirm)){
//            String passwordDontMatch = "Your passwords don't match.";
//            listOfErrors.add(passwordDontMatch);
//            hasInputErrors = true;
//        }
//
//        if(hasInputErrors){
//            request.setAttribute("listOfErrors", listOfErrors);
//            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
//        } else {
//            User sessionUser = (User) request.getSession().getAttribute("user");
//            User updateUser = new User(username_update, email_update, password_update);
//
//            if(!username_update.equals(sessionUser.getUsername()))
//                DaoFactory.getUsersDao().updateUsername(updateUser.getUsername(), sessionUser.getId());
//
//            if(!email_update.equals(sessionUser.getEmail()))
//                DaoFactory.getUsersDao().updateEmail(updateUser.getEmail(), sessionUser.getId());
//
//            if(!password_update.isEmpty())
//                DaoFactory.getUsersDao().updatePassword(updateUser.getPassword(), sessionUser.getId());
//
//            request.getSession().setAttribute("user", updateUser);
//            response.sendRedirect("/profile");
//        }
    }
}
