package com.mindhub.semfilgaming.DTOs;

import java.time.LocalDate;
import java.util.List;

public class PurchaseApplicationDTO {

    private Boolean accepted;

    private List<ProductPurchaseApplicationDTO> listProductPurchase;

    public PurchaseApplicationDTO(List<ProductPurchaseApplicationDTO> listProductPurchase, Boolean accepted){
        this.listProductPurchase = listProductPurchase;
        this.accepted = accepted;

    }

    public List<ProductPurchaseApplicationDTO> getListProductPurchase() {
        return listProductPurchase;
    }

    public Boolean getAccepted() {
        return accepted;
    }
}
