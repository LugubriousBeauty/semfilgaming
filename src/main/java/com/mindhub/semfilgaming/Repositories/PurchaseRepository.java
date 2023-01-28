package com.mindhub.semfilgaming.Repositories;

import com.mindhub.semfilgaming.Models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
