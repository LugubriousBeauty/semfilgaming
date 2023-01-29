package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long id;

    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    Set<ProductCategory> categories = new HashSet<>();

    public Category (){

    }

    public void addCategories(ProductCategory productCategory1){
        productCategory1.setCategory(this);
        categories.add(productCategory1);
    }

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }
}
