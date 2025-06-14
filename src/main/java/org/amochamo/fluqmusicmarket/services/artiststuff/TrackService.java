package org.amochamo.fluqmusicmarket.services.artiststuff;

import org.amochamo.fluqmusicmarket.repositories.artiststuff.TrackRepository;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

}
