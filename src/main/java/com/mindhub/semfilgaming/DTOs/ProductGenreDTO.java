package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.Genre;
import com.mindhub.semfilgaming.Models.ProductGenre;

import java.util.Set;

public class ProductGenreDTO {

    private GenreDTO genre;

    public ProductGenreDTO(ProductGenre genre){
        this.genre = new GenreDTO(genre.getGenre());
    }

    public GenreDTO getGenre() {
        return genre;
    }
}
