package com.mindhub.semfilgaming.Controllers;

import com.mindhub.semfilgaming.DTOs.GenreDTO;
import com.mindhub.semfilgaming.Models.Genre;
import com.mindhub.semfilgaming.Repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/genres")
    public List<GenreDTO> getAllGenres(){

        return genreRepository.findAll().stream().map(genre -> new GenreDTO(genre)).collect(Collectors.toList());
    }

    @PostMapping("/products/genre")
    public ResponseEntity<Object> newGenre(@RequestParam String genreName){
        if (genreName.isBlank()){
            return new ResponseEntity<>("Missing genre's name", HttpStatus.FORBIDDEN);
        }

        Genre newGenre = new Genre(genreName);
        genreRepository.save(newGenre);
        return new ResponseEntity<>("Genre created", HttpStatus.CREATED);
    }
}
