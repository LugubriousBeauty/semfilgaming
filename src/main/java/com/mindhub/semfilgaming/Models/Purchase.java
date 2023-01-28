package com.mindhub.semfilgaming.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    private ClientPurchase clientPurchase;

    private Double amountPayment;

    private int productQuantity;

    public Purchase(){}

    public Purchase(Double amountPayment, int productQuantity){
        this.amountPayment = amountPayment;
        this.productQuantity = productQuantity;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(Double amountPayment) {
        this.amountPayment = amountPayment;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ClientPurchase getClientPurchase() {
        return clientPurchase;
    }

    public void setClientPurchase(ClientPurchase clientPurchase) {
        this.clientPurchase = clientPurchase;
    }


}
