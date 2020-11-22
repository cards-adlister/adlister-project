package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;
    private Ad ad;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public List<Ad> userAds(long UserId) {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public List<Ad> individualAd(long AdId){
        if (ads == null){
            ads = generateAds();
        }
        return ads;
    }

    public void deleteAd(Ad ad) {
        if (ads == null) {
            ads = generateAds();
        }
    }

    public Ad getAdByID(long ad_id) {
        if (ads == null) {
            ads = generateAds();
        }
        return ad;
    }

    public void updateAd(Ad ad) {
        if (ads == null) {
            ads = generateAds();
        }
    }

    @Override
    public List<Ad> getAdsWithCategory(int categoryId) {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    @Override
    public List<Ad> searchAds(String search) {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public Long insert(Ad ad) {
        // make sure we have ads
        if (ads == null) {
            ads = generateAds();
        }
        // we'll assign an "id" here based on the size of the ads list
        // really the dao would handle this
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
            1,
            "Uno",
            "uno for sale",
            "https://libertyonthelighterside.com/wp-content/uploads/2020/04/boardgames-1024x768.jpg",
            4.50
        ));
        ads.add(new Ad(
            2,
            "Monopoly",
            "Monopoly for sale",
            "https://libertyonthelighterside.com/wp-content/uploads/2020/04/boardgames-1024x768.jpg",
                10
        ));
        ads.add(new Ad(
            3,
            "Darts",
            "Darts for sale",
            "https://libertyonthelighterside.com/wp-content/uploads/2020/04/boardgames-1024x768.jpg",
                15
        ));
        ads.add(new Ad(
            4,
            "Chess",
            "Chess for sale",
            "https://libertyonthelighterside.com/wp-content/uploads/2020/04/boardgames-1024x768.jpg",
                5.50
        ));
        return ads;
    }
}
