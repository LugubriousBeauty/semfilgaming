package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    private String cardNumber;

    private int cvv;

    private LocalDate thurDate;

    public ClientCard (){};

    public ClientCard(String cardNumber, int cvv, LocalDate thurDate){
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.thurDate = thurDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public LocalDate getThurDate() {
        return thurDate;
    }

    public void setThurDate(LocalDate thurDate) {
        this.thurDate = thurDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
