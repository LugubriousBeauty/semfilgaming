package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.Genre;
import org.springframework.stereotype.Service;


public interface GenreService {

    public Genre getGenreById(Long Id);
}
