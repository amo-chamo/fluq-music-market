package org.amochamo.fluqmusicmarket.models.compositekeys;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistTracksId {

    private Integer wishlistId;
    private Integer trackId;

}
