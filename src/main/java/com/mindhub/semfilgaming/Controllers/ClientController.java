package com.mindhub.semfilgaming.Controllers;

import com.mindhub.semfilgaming.DTOs.ClientDTO;
import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientService clientService;

    @GetMapping("/clients/{id}")
    public ClientDTO currentClient(@PathVariable Long id){
        return new ClientDTO(clientService.getClientById(id));
    }

    @GetMapping("/clients")
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClients().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/clients")
    public ResponseEntity<Object> registerClient(@RequestParam String firstName, @RequestParam String lastName,
                                                 @RequestParam String email, @RequestParam String password){

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (clientService.getClientByEmail(email) !=  null) {
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        Client client = new Client(email, passwordEncoder.encode(password), firstName, lastName, localDate);
        System.out.println(client);
        System.out.println();
        clientService.saveClient(client);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
