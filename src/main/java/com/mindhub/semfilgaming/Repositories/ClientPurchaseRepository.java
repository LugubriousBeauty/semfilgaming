package com.mindhub.semfilgaming.Repositories;

import com.mindhub.semfilgaming.Models.ClientPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientPurchaseRepository extends JpaRepository<ClientPurchase, Long> {
}
