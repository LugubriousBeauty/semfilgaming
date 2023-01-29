package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.Genre;
import com.mindhub.semfilgaming.Repositories.GenreRepository;
import com.mindhub.semfilgaming.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImplementation implements GenreService {

    @Autowired
    GenreRepository genreRepository;
    @Override
    public Genre getGenreById(Long Id) {
        return genreRepository.findById(Id).orElse(null);
    }
}
