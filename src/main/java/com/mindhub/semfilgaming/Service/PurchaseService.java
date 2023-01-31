package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PurchaseService {

    public void savePurchaseProduct(Purchase purchase);

    public List<Purchase> getAllPurchase();
}
