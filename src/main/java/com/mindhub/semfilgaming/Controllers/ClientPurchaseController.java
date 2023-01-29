package com.mindhub.semfilgaming.Controllers;

import com.mindhub.semfilgaming.DTOs.ClientPurchaseDTO;
import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Service.ClientPurchaseService;
import com.mindhub.semfilgaming.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientPurchaseController {

    @Autowired
    ClientPurchaseService clientPurchaseService;

    @Autowired
    ClientService clientService;

    @GetMapping("/clientpurchase")
    public List<ClientPurchaseDTO> getAllClientPurchase(){
        return clientPurchaseService.getAllClientPurchase().stream()
                .map(clientPurchase -> new ClientPurchaseDTO(clientPurchase))
                .collect(Collectors.toList());
    }

    @GetMapping("/clients/current/clientpurchase")
    public List<ClientPurchaseDTO> getCurrentClientPurchase(Authentication authentication){
        Client clientCurrent = clientService.getClientByEmail(authentication.getName());
        return clientCurrent.getClientPurchases().stream()
                .map(clientPurchase -> new ClientPurchaseDTO(clientPurchase))
                .collect(Collectors.toList());
    }
}
