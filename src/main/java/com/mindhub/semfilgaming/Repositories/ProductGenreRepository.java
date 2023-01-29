package com.mindhub.semfilgaming.Repositories;

import com.mindhub.semfilgaming.Models.ProductGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductGenreRepository extends JpaRepository<ProductGenre, Long> {
}
