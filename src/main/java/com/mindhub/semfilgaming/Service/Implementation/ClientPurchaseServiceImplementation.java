package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.ClientPurchase;
import com.mindhub.semfilgaming.Repositories.ClientPurchaseRepository;
import com.mindhub.semfilgaming.Service.ClientPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientPurchaseServiceImplementation implements ClientPurchaseService {

    @Autowired
    ClientPurchaseRepository clientPurchaseRepository;

    @Override
    public void saveClientPurchase(ClientPurchase clientPurchase) {
        clientPurchaseRepository.save(clientPurchase);
    }
}
