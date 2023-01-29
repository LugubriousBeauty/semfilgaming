package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Models.ClientPurchase;
import com.mindhub.semfilgaming.Models.Purchase;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientPurchaseDTO {

    private Set<PurchaseDTO> purchases;

    private LocalDateTime creationDate;

    private Double totalAmount;

    public ClientPurchaseDTO(ClientPurchase clientPurchase){
        this.creationDate = clientPurchase.getCreationDate();
        this.purchases = clientPurchase.getPurchases().stream()
                .map(purchase -> new PurchaseDTO(purchase))
                .collect(Collectors.toSet());
        this.totalAmount = clientPurchase.getTotalAmount();

    }

    public Set<PurchaseDTO> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<PurchaseDTO> purchases) {
        this.purchases = purchases;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
