package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ClientPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name= "native")
    private Long Id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clientPurchase")
    private Set<Purchase> purchases = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    private LocalDateTime creationDate;

    private Double totalAmount;

    public ClientPurchase(){}

    public ClientPurchase(LocalDateTime creationDate, Double totalAmount){
        this.creationDate = creationDate;
        this.totalAmount = totalAmount;
    }

    public void addPurchase(Purchase purchase){
        purchase.setClientPurchase(this);
        purchases.add(purchase);
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
