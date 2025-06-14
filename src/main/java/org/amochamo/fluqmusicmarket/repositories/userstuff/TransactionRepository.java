package org.amochamo.fluqmusicmarket.repositories.userstuff;

import org.amochamo.fluqmusicmarket.models.userstuff.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
