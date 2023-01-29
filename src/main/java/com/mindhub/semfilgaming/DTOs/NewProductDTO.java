package com.mindhub.semfilgaming.DTOs;

import java.util.List;

public class NewProductDTO {

    private String
            desc,
            desc_short,
            minimumReq,
            recommendedReq,
            gameName,
            imageHeader,
            website,
            background,
            rawBackground;

    private Double price, discount;

    private int stock;

    private List<String> screenShoots, trailers;

    List<Long> genres;

    List<Long> categories;

    public NewProductDTO(String desc, String desc_short, String minimumReq, String recommendedReq, String gameName,
                         String imageHeader, String website, String background, String rawBackground, Double price,
                         Double discount, int stock,List<String> screenShoots, List<String> trailers,
                         List<Long> genres,
                         List<Long> categories) {
        this.desc = desc;
        this.desc_short = desc_short;
        this.minimumReq = minimumReq;
        this.recommendedReq = recommendedReq;
        this.gameName = gameName;
        this.imageHeader = imageHeader;
        this.website = website;
        this.background = background;
        this.rawBackground = rawBackground;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.screenShoots = screenShoots;
        this.trailers = trailers;
        this.genres = genres;
        this.categories = categories;
    }

    public String getDesc() {
        return desc;
    }

    public String getDesc_short() {
        return desc_short;
    }

    public String getMinimumReq() {
        return minimumReq;
    }

    public String getRecommendedReq() {
        return recommendedReq;
    }

    public String getGameName() {
        return gameName;
    }

    public String getImageHeader() {
        return imageHeader;
    }

    public String getWebsite() {
        return website;
    }

    public String getBackground() {
        return background;
    }

    public String getRawBackground() {
        return rawBackground;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public List<String> getScreenShoots() {
        return screenShoots;
    }

    public List<String> getTrailers() {
        return trailers;
    }

    public List<Long> getGenres() {
        return genres;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
