package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.PasswordResetToken;
import com.mindhub.semfilgaming.Repositories.PasswordResetTokenRepository;
import com.mindhub.semfilgaming.Service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PasswordResetTokenImplementation implements PasswordResetTokenService {

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public PasswordResetToken findByPasswordResetToken(String passwordResetToken) {
        return passwordResetTokenRepository.findByPasswordResetToken(passwordResetToken);
    }

    @Override
    public void savePasswordResetToken(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.save(passwordResetToken);
    }
}
