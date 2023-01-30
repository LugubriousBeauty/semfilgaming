package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.Product;

import java.util.List;
import java.util.stream.Collectors;


public class ProductDTO {

    private Long Id;

    private String desc;


    private String desc_short;


    private String minimumReq, recommendedReq;

    private String gameName, imageHeader, website, background, rawBackground;

    private Double price, discount;

    private int stock, salesHistory;

    private List<String> screenShoots, trailers;

    List<ProductGenreDTO> genreDTOS;

    List<ProductCategoryDTO> categories;

    public ProductDTO(){

    }

    public ProductDTO (Product product){
        this.Id= product.getId();
        this.background = product.getBackground();
        this.desc_short = product.getDesc_short();
        this.desc = product.getDesc();
        this.discount = product.getDiscount();
        this.gameName = product.getGameName();
        this.imageHeader = product.getImageHeader();
        this.minimumReq = product.getMinimumReq();
        this.recommendedReq = product.getRecommendedReq();
        this.price = product.getPrice();
        this.rawBackground = product.getRawBackground();
        this.stock = product.getStock();
        this.salesHistory = product.getSalesHistory();
        this.website = product.getWebsite();
        this.screenShoots = product.getScreenShoot();
        this.trailers = product.getTrailers();
        this.categories=
                product.getCategories().stream()
                        .map(categories1 -> new ProductCategoryDTO(categories1))
                        .collect(Collectors.toList());
        this.genreDTOS = product.getGenres().stream()
                .map(productGenre -> new ProductGenreDTO(productGenre))
                .collect(Collectors.toList());

    }

    public Long getId() {
        return Id;
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

    public List<ProductCategoryDTO> getCategories() {
        return categories;
    }

    public List<ProductGenreDTO> getGenreDTOS() {
        return genreDTOS;
    }

    public int getSalesHistory() {
        return salesHistory;
    }
}
