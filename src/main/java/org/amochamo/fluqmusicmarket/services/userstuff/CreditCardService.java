package org.amochamo.fluqmusicmarket.services.userstuff;

import org.amochamo.fluqmusicmarket.repositories.userstuff.CreditCardRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

}
