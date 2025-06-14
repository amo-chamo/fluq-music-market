package org.amochamo.fluqmusicmarket.services.roles;

import org.amochamo.fluqmusicmarket.repositories.roles.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

}
