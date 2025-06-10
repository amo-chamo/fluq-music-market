package org.amochamo.fluqmusicmarket.models.mappingentities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.artiststuff.Track;
import org.amochamo.fluqmusicmarket.models.userstuff.Wishlist;
import org.amochamo.fluqmusicmarket.models.compositekeys.WishlistTracksId;

@Entity
@Table(name = "wishlist_tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistTrack {

    @EmbeddedId
    private WishlistTracksId id = new WishlistTracksId();

    @ManyToOne
    @MapsId("wishlistId")
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn(name = "track_id")
    private Track track;

    public WishlistTrack(Wishlist wishlist, Track track) {
        this.wishlist = wishlist;
        this.track = track;
        this.id = new WishlistTracksId(wishlist.getId(), track.getId());
    }

}
