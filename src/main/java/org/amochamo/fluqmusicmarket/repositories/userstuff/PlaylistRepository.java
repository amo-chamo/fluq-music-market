package org.amochamo.fluqmusicmarket.repositories.userstuff;

import org.amochamo.fluqmusicmarket.models.userstuff.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}
