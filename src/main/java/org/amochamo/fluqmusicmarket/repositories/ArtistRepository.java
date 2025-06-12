package org.amochamo.fluqmusicmarket.repositories;

import org.amochamo.fluqmusicmarket.models.roles.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Optional<Artist> findByArtistName(String artistName);

    Optional<Artist> findByEmail(String email);

    boolean existsByArtistName(String artistName);

    boolean existsByEmail(String email);
}
