package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long Id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genre")
    Set<ProductGenre> genres = new HashSet<>();

    private String genreName;

    public Genre (){}

    public void addGenre(ProductGenre genre){
        genre.setGenre(this);
        genres.add(genre);
    }

    public Genre(String genreName){
        this.genreName = genreName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<ProductGenre> getGenres() {
        return genres;
    }

    public void setGenres(Set<ProductGenre> genres) {
        this.genres = genres;
    }
}
