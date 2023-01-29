package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.Client;


import java.util.List;


public interface ClientService {

    Client getClientById(Long id);
    List<Client> getAllClients();
    Client getClientByEmail(String email);

    void saveClient(Client client);
}
