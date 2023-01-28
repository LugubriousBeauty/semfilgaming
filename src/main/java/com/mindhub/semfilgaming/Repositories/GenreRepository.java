package com.mindhub.semfilgaming.Repositories;

import com.mindhub.semfilgaming.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
