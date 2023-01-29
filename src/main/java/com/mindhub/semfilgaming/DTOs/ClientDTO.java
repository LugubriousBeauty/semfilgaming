package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private Long Id;

    private String clientEmail,password, firstName, lastName;

    private LocalDate creationDate;

    private List<ClientPurchaseDTO> clientPurchases;

    private Set<ClientCardDTO> clientCards;

    public ClientDTO(Client client){
        this.Id = client.getId();
        this.clientEmail = client.getClientEmail();
        this.password = client.getPassword();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.creationDate = client.getCreationDate();
        this.clientPurchases = client.getClientPurchases().stream()
                .map(clientPurchase -> new ClientPurchaseDTO(clientPurchase))
                .collect(Collectors.toList());
        this.clientCards = client.getClientCards().stream()
                .map(clientCard -> new ClientCardDTO(clientCard))
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return Id;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<ClientPurchaseDTO> getClientPurchases() {
        return clientPurchases;
    }

    public Set<ClientCardDTO> getClientCards() {
        return clientCards;
    }
}
