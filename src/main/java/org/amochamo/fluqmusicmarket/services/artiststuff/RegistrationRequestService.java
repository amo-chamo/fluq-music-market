package org.amochamo.fluqmusicmarket.services.artiststuff;

import org.amochamo.fluqmusicmarket.repositories.artiststuff.RegistrationRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestService {

    private final RegistrationRequestRepository registrationRequestRepository;

    public RegistrationRequestService(RegistrationRequestRepository registrationRequestRepository) {
        this.registrationRequestRepository = registrationRequestRepository;
    }

}
