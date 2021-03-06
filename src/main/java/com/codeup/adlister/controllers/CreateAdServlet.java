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
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        request.setAttribute("usersDao", DaoFactory.getUsersDao());
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String[] categories = request.getParameterValues("category");
        User user = (User) request.getSession().getAttribute("user");
//        String title = request.getParameter("title");
//        String description = request.getParameter("description");
//        String image = request.getParameter("image");
//        Double price = Double.parseDouble(request.getParameter("price"));

        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("image"),
                Double.parseDouble(request.getParameter("price"))
        );

        DaoFactory.getAdsDao().insert(ad);
        for (String catId : categories) {
            DaoFactory.getAdsDao().linkAdToCategory(DaoFactory.getAdsDao().all().size(), Integer.parseInt(catId));
        }
        response.sendRedirect("/ads");
    }
}
