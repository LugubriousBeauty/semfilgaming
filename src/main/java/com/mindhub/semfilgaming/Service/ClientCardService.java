package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.ClientCard;


import java.util.List;


public interface ClientCardService {

    public List<ClientCard> getAllCards();

    public void saveClientCard(ClientCard clientCard);
}
