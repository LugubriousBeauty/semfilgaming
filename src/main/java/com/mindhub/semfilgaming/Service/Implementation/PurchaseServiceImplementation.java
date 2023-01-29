package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.Purchase;
import com.mindhub.semfilgaming.Repositories.PurchaseRepository;
import com.mindhub.semfilgaming.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImplementation implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    @Override
    public void savePurchaseProduct(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
