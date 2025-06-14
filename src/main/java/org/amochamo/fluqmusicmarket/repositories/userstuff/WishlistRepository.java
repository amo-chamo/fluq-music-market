package org.amochamo.fluqmusicmarket.repositories.userstuff;

import org.amochamo.fluqmusicmarket.models.userstuff.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}
