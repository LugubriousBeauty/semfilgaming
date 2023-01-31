package com.mindhub.semfilgaming.Controllers;

import com.mindhub.semfilgaming.DTOs.ClientDTO;
import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Models.ConfirmationToken;
import com.mindhub.semfilgaming.Models.PasswordResetToken;
import com.mindhub.semfilgaming.Service.ClientService;
import com.mindhub.semfilgaming.Service.ConfirmationTokenService;
import com.mindhub.semfilgaming.Service.EmailSenderService;
import com.mindhub.semfilgaming.Service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientService clientService;

    @Autowired
    ConfirmationTokenService confirmationTokenService;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/clients/{id}")
    public ClientDTO currentClient(@PathVariable Long id){
        return new ClientDTO(clientService.getClientById(id));
    }

    @GetMapping("/clients")
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClients().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/clients/current")
    public ClientDTO getCurrentClient(Authentication authentication){
        return new ClientDTO(clientService.getClientByEmail(authentication.getName()));
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

        Client client = new Client(email, passwordEncoder.encode(password), firstName, lastName, localDate);
        clientService.saveClient(client);

        ConfirmationToken confirmationToken = new ConfirmationToken(client);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(client.getClientEmail());
        mailMessage.setSubject("Complete Registration!");

        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:8080/web/confirm-account.html?token="+confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(path="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Object> confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        System.out.println(confirmationToken);
        ConfirmationToken token = confirmationTokenService.findByConfirmationToken(confirmationToken);
        LocalDateTime today = LocalDateTime.now().minusHours(24);
        System.out.println(token);

        if(token != null || today.isAfter(token.getCreatedDate()))
        {
            Client client = clientService.getClientByEmail(token.getClient().getClientEmail());
            client.setEnabled(true);
            clientService.saveClient(client);
        }
        else
        {
            ConfirmationToken newToken = new ConfirmationToken(token.getClient());
            confirmationTokenService.saveConfirmationToken(newToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(token.getClient().getClientEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("chand312902@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    +"/web/confirm-account.html?token="+newToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);
            return new ResponseEntity<>("invalid link or expired token. We sent you a new one",HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>("account activated",HttpStatus.ACCEPTED);
    }

    @PostMapping("/password-token")
    public ResponseEntity<Object> sendPasswordResetToken(@RequestParam String email) {
        Client client = clientService.getClientByEmail(email);
        if (client == null) {
            new ResponseEntity<>("Email doesn't exist", HttpStatus.FORBIDDEN);
        }
        clientService.saveClient(client);
        PasswordResetToken passwordResetToken = new PasswordResetToken(client);
        passwordResetTokenService.savePasswordResetToken(passwordResetToken);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(client.getClientEmail());
        mailMessage.setSubject("Change password");
        mailMessage.setFrom("chand312902@gmail.com");
        mailMessage.setText("To change your password, please click here : "
                +"/web/reset-password.html?token="+passwordResetToken.getPasswordResetToken());

        emailSenderService.sendEmail(mailMessage);

        return new ResponseEntity<>("Token sent", HttpStatus.ACCEPTED);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Object> resetPassword(@RequestParam("token")String passwordResetToken, @RequestParam String password) {
        PasswordResetToken token = passwordResetTokenService.findByPasswordResetToken(passwordResetToken);
        if(token != null) {
            Client client = clientService.getClientByEmail(token.getClient().getClientEmail());
            client.setPassword(passwordEncoder.encode(password));
            clientService.saveClient(client);
        } else {
            return new ResponseEntity<>("token is not valid", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("changed password", HttpStatus.CREATED);
    }



}
