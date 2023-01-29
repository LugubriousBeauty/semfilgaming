package com.mindhub.semfilgaming.Repositories;

import com.mindhub.semfilgaming.Models.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
}
