package org.amochamo.fluqmusicmarket.models.artiststuff;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.mappingentities.CartTrack;
import org.amochamo.fluqmusicmarket.models.mappingentities.PlaylistTrack;
import org.amochamo.fluqmusicmarket.models.mappingentities.WishlistTrack;
import org.amochamo.fluqmusicmarket.models.roles.Artist;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "track")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "duration_seconds", nullable = false)
    private Integer durationSeconds;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @Column(name = "music_file", nullable = false)
    private byte[] musicFile;

    @Column(name = "preview_file", nullable = false)
    private byte[] previewFile;

    @Column(name = "cover_image", nullable = false)
    private byte[] coverImage;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartTrack> cartTracks = new HashSet<>();

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WishlistTrack> wishlistTracks = new HashSet<>();

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlaylistTrack> playlistTracks = new HashSet<>();

}
