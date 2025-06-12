package org.amochamo.fluqmusicmarket.repositories;

import org.amochamo.fluqmusicmarket.models.artiststuff.Track;
import org.amochamo.fluqmusicmarket.models.roles.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findByArtist(Artist artist);

    List<Track> findByArtist_Id(Integer artistId);
}
