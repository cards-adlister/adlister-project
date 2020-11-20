package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
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

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> userAds(long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = '" + userId + "'");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> individualAd(long adId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = " + adId);
            ResultSet rs = stmt.executeQuery();
            return createAdFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Ad getAdByID(long ad_id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ? LIMIT 1");
            stmt.setLong(1, ad_id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs).get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all user ads.", e);
        }
    }

    @Override
    public void updateAd(Ad ad) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE ads SET title = ?, description = ?, image = ?, price = ? WHERE id = ?");
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setString(3, ad.getImage());
            stmt.setDouble(4, ad.getPrice());
            stmt.setLong(5, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating your ad");
        }
    }

    @Override
    public void deleteAd(Ad ad) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM ads WHERE id = ?");
            stmt.setLong(1, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, image, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
<<<<<<< HEAD
            stmt.setString(4, ad.getImage());
=======
            stmt.setString(4,ad.getImage());
            stmt.setDouble(5,ad.getPrice());
>>>>>>> a372774b651743c1ac0ddd863a2f9821e091700f
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
<<<<<<< HEAD
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("image")
=======
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("image"),
            rs.getDouble("price")
>>>>>>> a372774b651743c1ac0ddd863a2f9821e091700f
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    //Function to view individual Ad
    private List<Ad> createAdFromResults(ResultSet rs) throws SQLException {
        List<Ad> ad = new ArrayList<>();
        rs.next();
        ad.add(extractAd(rs));
        return ad;
    }

    @Override
    public List<Ad> getAdsWithCategory(int categoryId) {
        List<Ad> ads = new ArrayList<>();
        try {
            String query = "select * from ads where id in ( select ad_id from category_ad_pivot where category_id = ? )";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getString("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting ads from category", e);
        }
        return ads;
    }

    public long linkAdToCategory(int adId, int catId) {
        try {
            String query = "INSERT INTO ad_category (ad_id, category_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, adId);
            stmt.setInt(2, catId);
            return (long) stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not link ad to category!", e);
        }
    }

    @Override
    public List<Ad> searchAds(String search) {
        try {
            String select = "SELECT * FROM ads where description LIKE CONCAT(\"%\", ?, \"%\") or title LIKE CONCAT(\"%\", ?, \"%\")";
            PreparedStatement stmt = connection.prepareStatement(select);
            stmt.setString(1, search);
            stmt.setString( 2, search);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("No ads matched your search.", e);
        }
    }

}
//    public List<Ad> searchAds(String search) throws SQLException {
//        List<Ad> adList = new ArrayList<>();
//        String sqlQuery = "SELECT id FROM ads WHERE title LIKE ?";
//        try{
//            PreparedStatement stmt = connection.prepareStatement(sqlQuery, Statement.NO_GENERATED_KEYS);
//            stmt.setString(1, "%" + search + "%");
//            stmt.executeQuery();
//            ResultSet rs = stmt.getResultSet();
//            rs.next();
////            return rs.getString(1);
//            while (rs.next()) {
//                adList.add(findUniqueAdId(rs.getLong("id")));
//            }
//        }catch (RuntimeException e){
//            throw new RuntimeException("No ads matched search.", e);
//        }
//            return adList;
//    }
//
//
//    public Ad findUniqueAdId(Long ad) {
//        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setLong(1, ad);
//            ResultSet rs = stmt.executeQuery();
//            if (!rs.next()) {
//                return null;
//            }
//            return extractAd(rs);
//        } catch (RuntimeException | SQLException e) {
//            throw new RuntimeException("Error finding Ad ID", e);
//        }
//    }

//        String query = "SELECT * FROM ads WHERE title LIKE ?";
//        String searchWithWildCards = "%" + title + "%";
//        try{
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setString(1, searchWithWildCards);
//            ResultSet rs = stmt.executeQuery();
//            return (List<Ad>) (rs = stmt.executeQuery());
//        }catch (SQLException e){
//            throw new RuntimeException("No ad title matched your search.", e);
//        }
//    }

