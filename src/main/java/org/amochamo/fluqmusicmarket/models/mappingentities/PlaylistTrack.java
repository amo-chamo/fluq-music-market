package org.amochamo.fluqmusicmarket.models.mappingentities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.artiststuff.Track;
import org.amochamo.fluqmusicmarket.models.userstuff.Playlist;
import org.amochamo.fluqmusicmarket.models.compositekeys.PlaylistTrackId;

@Entity
@Table(name = "playlist_tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistTrack {

    @EmbeddedId
    private PlaylistTrackId id = new PlaylistTrackId();

    @ManyToOne
    @MapsId("playlistId")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn(name = "track_id")
    private Track track;

    public PlaylistTrack(Playlist playlist, Track track) {
        this.playlist = playlist;
        this.track = track;
        this.id = new PlaylistTrackId(playlist.getId(), track.getId());
    }

}
