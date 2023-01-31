package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.Genre;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GenreService {

    public Genre getGenreById(Long Id);

    public List<Genre> getAllGenres();

    public void saveGenre(Genre genre);
}
