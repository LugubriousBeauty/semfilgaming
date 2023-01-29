package com.mindhub.semfilgaming.Repositories;

import com.mindhub.semfilgaming.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
