package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
<<<<<<< HEAD
    List<Ad> userAds(long userId);
    void deleteAd(Ad ad);
    Ad getAdByID(long ad_id);
    void updateAd(Ad ad);
    List<Ad> getAdsWithCategory(int categoryId);
    List<Ad> searchAds(String search);
    int linkAdToCategory(int adId, int catId);
=======
>>>>>>> fc613a62857fe205549cf62f1a48c67d349cadc5
}
