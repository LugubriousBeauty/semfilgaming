package com.mindhub.semfilgaming.DTOs;

import java.time.LocalDate;
import java.util.List;

public class PurchaseApplicationDTO {

    private LocalDate thurDate;

    private String cardNumber;

    private int cvv;

    private List<ProductPurchaseApplicationDTO> listProductPurchase;

    public PurchaseApplicationDTO(List<ProductPurchaseApplicationDTO> listProductPurchase, LocalDate thurDate,
                                  String cardNumber, int cvv){
        this.listProductPurchase = listProductPurchase;
        this.cvv = cvv;
        this.thurDate = thurDate;
        this.cardNumber = cardNumber;
    }

    public List<ProductPurchaseApplicationDTO> getListProductPurchase() {
        return listProductPurchase;
    }

    public LocalDate getThurDate() {
        return thurDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }
}
