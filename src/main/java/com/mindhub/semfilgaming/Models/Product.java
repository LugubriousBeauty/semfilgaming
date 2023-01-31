package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long Id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<ProductCategory> categories  = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<ProductGenre> genres = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<Purchase> purchases = new HashSet<>();

    @Column(columnDefinition = "TEXT")
    private String desc;

    @Column(columnDefinition = "TEXT")
    private String desc_short;

    @Column(columnDefinition = "TEXT")
    private String minimumReq, recommendedReq;

    private String gameName, imageHeader, website, background, rawBackground;

    private Double price, discount;

    @ElementCollection
    @Column(columnDefinition = "TEXT")
    private List<String> screenShoot;

    @ElementCollection
    @Column(columnDefinition = "TEXT")
    private List<String> trailers;

    private int stock, salesHistory;

    public Product(){

    }

    public Product(String desc,
                   String desc_short,
                   String minimumReq,
                   String recommendedReq,
                   String gameName,
                   String imageHeader,
                   String website,
                   String background,
                   String rawBackground,
                   Double price,
                   Double discount,
                   int stock,
                   int salesHistory,
                   List<String> screenShoot,
                   List<String> trailers) {
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
        this.salesHistory = salesHistory;
        this.screenShoot = screenShoot;
        this.trailers = trailers;
    }

    public void addCategories(ProductCategory category){
        category.setProduct(this);
        categories.add(category);
    }

    public void addGenre(ProductGenre genre){
        genre.setProduct(this);
        genres.add(genre);
    }

    public void addPurchase(Purchase purchase){
        purchase.setProduct(this);
        purchases.add(purchase);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc_short() {
        return desc_short;
    }

    public void setDesc_short(String desc_short) {
        this.desc_short = desc_short;
    }

    public String getMinimumReq() {
        return minimumReq;
    }

    public void setMinimumReq(String minimumReq) {
        this.minimumReq = minimumReq;
    }

    public String getRecommendedReq() {
        return recommendedReq;
    }

    public void setRecommendedReq(String recommendedReq) {
        this.recommendedReq = recommendedReq;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getImageHeader() {
        return imageHeader;
    }

    public void setImageHeader(String imageHeader) {
        this.imageHeader = imageHeader;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getRawBackground() {
        return rawBackground;
    }

    public void setRawBackground(String rawBackground) {
        this.rawBackground = rawBackground;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSalesHistory() {
        return salesHistory;
    }

    public void setSalesHistory(int salesHistory) {
        this.salesHistory = salesHistory;
    }

    public List<String> getScreenShoot() {
        return screenShoot;
    }

    public void setScreenShoot(List<String> screenShoot) {
        this.screenShoot = screenShoot;
    }

    public List<String> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<String> trailers) {
        this.trailers = trailers;
    }

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }

    public Set<ProductGenre> getGenres() {
        return genres;
    }

    public void setGenres(Set<ProductGenre> genres) {
        this.genres = genres;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }
}
