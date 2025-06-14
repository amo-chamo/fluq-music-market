package org.amochamo.fluqmusicmarket.repositories.userstuff;

import org.amochamo.fluqmusicmarket.models.userstuff.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}
