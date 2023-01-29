package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.ClientCard;
import com.mindhub.semfilgaming.Repositories.ClientCardRepository;
import com.mindhub.semfilgaming.Service.ClientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardServiceImplementation implements ClientCardService {

    @Autowired
    ClientCardRepository clientCardRepository;

    @Override
    public List<ClientCard> getAllCards() {
        return clientCardRepository.findAll();
    }

    @Override
    public void saveClientCard(ClientCard clientCard) {
        clientCardRepository.save(clientCard);
    }
}
