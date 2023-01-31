package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.ConfirmationToken;

public interface ConfirmationTokenService {

    public ConfirmationToken findByConfirmationToken(String confirmationToken);

    public void saveConfirmationToken(ConfirmationToken confirmationToken);
}
