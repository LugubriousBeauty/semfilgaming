package com.mindhub.semfilgaming.DTOs;

public class ProductPurchaseApplicationDTO {

    private Long productId;

    private int productQuantity;

    public ProductPurchaseApplicationDTO(Long productId, int productQuantity){
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
