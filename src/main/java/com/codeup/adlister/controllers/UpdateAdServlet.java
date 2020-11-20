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

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/update/*")
public class UpdateAdServlet extends HttpServlet {
    Ad ad;
    long adId;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedAd = request.getPathInfo();
        try {
            adId = Long.parseLong(selectedAd.substring(1));
            ad = DaoFactory.getAdsDao().getAdByID(adId);
            request.setAttribute("ad", ad);
            request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/updateAd.jsp").forward(request, response);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(adId);
        String title_update = request.getParameter("title");
        String description_update = request.getParameter("description");
        String image_update = request.getParameter("image");
        double price_update = Double.parseDouble(request.getParameter("price"));
        String[] categories = request.getParameterValues("category");

        ad.setId(adId);
        ad.setTitle(title_update);
        ad.setDescription(description_update);
        ad.setImage(image_update);
        ad.setPrice(price_update);
        DaoFactory.getAdsDao().updateAd(ad);
        for (String catId : categories) {
            DaoFactory.getAdsDao().linkAdToCategory(DaoFactory.getAdsDao().all().size(), Integer.parseInt(catId));
        }
        response.sendRedirect("/profile");
    }
}
