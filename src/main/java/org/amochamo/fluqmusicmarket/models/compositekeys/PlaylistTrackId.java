package org.amochamo.fluqmusicmarket.models.compositekeys;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistTrackId {

    private Integer playlistId;
    private Integer trackId;

}
