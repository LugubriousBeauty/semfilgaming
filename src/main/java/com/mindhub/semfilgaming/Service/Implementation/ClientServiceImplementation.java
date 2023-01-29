package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Repositories.ClientRepository;
import com.mindhub.semfilgaming.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByClientEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}
