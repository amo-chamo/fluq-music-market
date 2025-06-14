package org.amochamo.fluqmusicmarket.services.userstuff;

import org.amochamo.fluqmusicmarket.repositories.userstuff.PlaylistRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

}
