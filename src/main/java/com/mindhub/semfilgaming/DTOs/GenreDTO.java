package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.Genre;

public class GenreDTO {

    private Long Id;

    private String genreName;

    public GenreDTO(Genre genre){
        this.Id = genre.getId();
        this.genreName = genre.getGenreName();
    }

    public Long getId() {
        return Id;
    }

    public String getGenreName() {
        return genreName;
    }
}
