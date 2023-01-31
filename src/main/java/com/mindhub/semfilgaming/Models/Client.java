package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long Id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private Set<ClientPurchase> clientPurchases = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private Set<ClientCard> clientCards = new HashSet<>();

    private String clientEmail, password, firstName, lastName;

    private LocalDate creationDate;

    private boolean isEnabled, isAdmin;

    public Client (){}

    public Client(String clientEmail, String password, String firstName, String lastName, LocalDate creationDate){
        this.clientEmail = clientEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.creationDate= creationDate;
    }

    public void addClientCard(ClientCard clientCard){
        clientCard.setClient(this);
        clientCards.add(clientCard);
    }

    public void addClientPurchase(ClientPurchase clientPurchase){
        clientPurchase.setClient(this);
        clientPurchases.add(clientPurchase);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<ClientPurchase> getClientPurchases() {
        return clientPurchases;
    }

    public void setClientPurchases(Set<ClientPurchase> clientPurchases) {
        this.clientPurchases = clientPurchases;
    }

    public Set<ClientCard> getClientCards() {
        return clientCards;
    }

    public void setClientCards(Set<ClientCard> clientCards) {
        this.clientCards = clientCards;
    }
}
