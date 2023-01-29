package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.ClientCard;

import java.time.LocalDate;

public class ClientCardDTO {

    private Long Id;

    private String cardNumber;

    private int cvv;

    private LocalDate thurDate;

    public ClientCardDTO(ClientCard clientCard){
        this.Id = clientCard.getId();
        this.cardNumber = clientCard.getCardNumber();
        this.thurDate = clientCard.getThurDate();
        this.cvv= clientCard.getCvv();
    }

    public Long getId() {
        return Id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getThurDate() {
        return thurDate;
    }
}
