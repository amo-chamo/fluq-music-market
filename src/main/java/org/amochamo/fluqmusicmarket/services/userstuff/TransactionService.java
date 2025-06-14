package org.amochamo.fluqmusicmarket.services.userstuff;

import org.amochamo.fluqmusicmarket.repositories.userstuff.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

}
