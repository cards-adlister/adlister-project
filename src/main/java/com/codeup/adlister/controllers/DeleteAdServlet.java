package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/delete/*")
public class DeleteAdServlet extends HttpServlet {
    Ad ad;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedAd = request.getPathInfo();
        try {
            long adId = Long.parseLong(selectedAd.substring(1));
            ad = DaoFactory.getAdsDao().getAdByID(adId);
            request.setAttribute("ad", ad);
            request.getRequestDispatcher("/WEB-INF/ads/DeleteAd.jsp").forward(request, response);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DaoFactory.getAdsDao().deleteAd(ad);
        response.sendRedirect("/profile");
        }
    }
