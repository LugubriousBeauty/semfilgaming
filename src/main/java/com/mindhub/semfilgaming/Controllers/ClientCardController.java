package com.mindhub.semfilgaming.Controllers;

import com.mindhub.semfilgaming.DTOs.ClientCardDTO;
import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Models.ClientCard;
import com.mindhub.semfilgaming.Service.ClientCardService;
import com.mindhub.semfilgaming.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientCardController {

    @Autowired
    ClientCardService clientCardService;

    @Autowired
    ClientService clientService;

    @GetMapping("/cards")
    public List<ClientCardDTO> getAllCards(){
        return clientCardService.getAllCards().stream()
                .map(clientCard -> new ClientCardDTO(clientCard))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/clients/current/cards")
    public List<ClientCardDTO> getCurrentClientCards(Authentication authentication){
        return clientService.getClientByEmail(authentication.getName())
                .getClientCards().stream()
                .map(clientCard -> new ClientCardDTO(clientCard))
                .collect(Collectors.toList());
    }

    @PostMapping("/api/clients/current/cards")
    public ResponseEntity<Object> newClientCard(Authentication authentication,
                                                @RequestParam String cardNumber, @RequestParam int cvv,
                                                @RequestParam LocalDate thurDate){
        Client currentClient = clientService.getClientByEmail(authentication.getName());
        ClientCard newClientCard = new ClientCard(cardNumber, cvv, thurDate);
        clientCardService.saveClientCard(newClientCard);
        currentClient.addClientCard(newClientCard);

        return new ResponseEntity<>("Created", HttpStatus.CREATED );
    }

}
