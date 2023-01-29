package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    Genre genre;

    @ManyToOne(fetch = FetchType.EAGER)
    Product product;

    public ProductGenre(){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
