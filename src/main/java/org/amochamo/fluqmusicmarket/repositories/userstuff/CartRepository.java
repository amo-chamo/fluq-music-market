package org.amochamo.fluqmusicmarket.repositories.userstuff;

import org.amochamo.fluqmusicmarket.models.userstuff.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
