package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.PasswordResetToken;

public interface PasswordResetTokenService {

    public PasswordResetToken findByPasswordResetToken(String passwordResetToken);

    public void savePasswordResetToken(PasswordResetToken passwordResetToken);
}
