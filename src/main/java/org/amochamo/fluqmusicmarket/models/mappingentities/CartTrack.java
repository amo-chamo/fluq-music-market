package org.amochamo.fluqmusicmarket.models.mappingentities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.artiststuff.Track;
import org.amochamo.fluqmusicmarket.models.userstuff.Cart;
import org.amochamo.fluqmusicmarket.models.compositekeys.CartTrackId;

@Entity
@Table(name = "cart_tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartTrack {

    @EmbeddedId
    private CartTrackId id = new CartTrackId();

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn(name = "track_id")
    private Track track;

    public CartTrack(Cart cart, Track track) {
        this.cart = cart;
        this.track = track;
        this.id = new CartTrackId(cart.getId(), track.getId());
    }

}
