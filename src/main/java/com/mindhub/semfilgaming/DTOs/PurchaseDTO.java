package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.Purchase;

public class PurchaseDTO {

    private Double amountPayment;

    private int productQuantity;

    private ProductDTO productDTO;


    public PurchaseDTO(Purchase purchase){
        this.productQuantity = purchase.getProductQuantity();
        this.amountPayment = purchase.getAmountPayment();
        this.productDTO = new ProductDTO (purchase.getProduct());
    }

    public Double getAmountPayment() {
        return amountPayment;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }
}
