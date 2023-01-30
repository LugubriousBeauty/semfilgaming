package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.ConfirmationToken;
import com.mindhub.semfilgaming.Repositories.ConfirmationTokenRepository;
import com.mindhub.semfilgaming.Service.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenImplementation implements ConfirmationTokenService {

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return confirmationTokenRepository.findByConfirmationToken(confirmationToken);
    }

    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }
}
