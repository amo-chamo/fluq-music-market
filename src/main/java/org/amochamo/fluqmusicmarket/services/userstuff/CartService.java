package org.amochamo.fluqmusicmarket.services.userstuff;

import org.amochamo.fluqmusicmarket.repositories.userstuff.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

}
