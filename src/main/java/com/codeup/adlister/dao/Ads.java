package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // get individual ad
    List<Ad> individualAd(long adId);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    List<Ad> userAds(long userId);
    void deleteAd(Ad ad);
    Ad getAdByID(long ad_id);
    void updateAd(Ad ad);
    List<Ad> getAdsWithCategory(int categoryId);
    List<Ad> searchAds(String search);
    int linkAdToCategory(int adId, int catId);
}
