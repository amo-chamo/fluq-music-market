package org.amochamo.fluqmusicmarket.models.userstuff;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.mappingentities.PlaylistTrack;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    @Column(nullable = false)
    private String name = "New Playlist";

    @Column(name = "is_uncategorized", nullable = false)
    private Boolean isUncategorized = false;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlaylistTrack> playlistTracks = new HashSet<>();


}
