package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    private List<Category> categories;

    @Override
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return  createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getInt("id"),
                rs.getString("name")
        );
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }

    @Override
    public int insert(Category category) {
        try {
            String insertQuery = "INSERT INTO categories(id, name) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, category.getId());
            stmt.setString(2, category.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating category.", e);
        }
    }

    @Override
    public List<Category> getCategoriesWithAd(int adId) {
        List<Category> categories = new ArrayList<>();
        try {
            String query = "select * from categories where id in ( select category_id from category_ad_pivot where ad_id = ? )";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, adId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                categories.add(new Category(rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting categories from adId", e);
        }
        return categories;
    }

}