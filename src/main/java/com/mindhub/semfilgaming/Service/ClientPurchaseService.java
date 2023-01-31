package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.ClientPurchase;

import java.util.List;


public interface ClientPurchaseService {

    public void saveClientPurchase(ClientPurchase clientPurchase);

    public List<ClientPurchase> getAllClientPurchase();

}
