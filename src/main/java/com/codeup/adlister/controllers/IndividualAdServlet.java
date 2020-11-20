package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndividualAdServlet", urlPatterns = "/ad/*")
public class IndividualAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selectedAd = request.getPathInfo();

        try {

            int adId = Integer.parseInt(selectedAd.substring(1));
            Ad ad = DaoFactory.getAdsDao().all().get(adId - 1);
            request.setAttribute("ad", ad);
            request.setAttribute("user", DaoFactory.getUsersDao().findById(ad.getUserId()));
            request.setAttribute("categories", DaoFactory.getCategoriesDao().getCategoriesWithAd(adId));
            request.getRequestDispatcher("/WEB-INF/ads/individualAd.jsp").forward(request, response);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            request.setAttribute("error", "Requested invalid ad listing!");
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }

    }
}