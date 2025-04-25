package com.musicstore.themusicstoreapp.accessors.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "playlisttrack")
@IdClass(PlaylistTrackId.class)
public class PlaylistTrack implements Serializable {

    @Id
    @Column(name = "playlist_id", nullable = false)
    private UUID playlistId;

    @Id
    @Column(name = "track_id", nullable = false)
    private UUID trackId;

    public PlaylistTrack() {}

    public PlaylistTrack(UUID playlistId, UUID trackId) {
        this.playlistId = playlistId;
        this.trackId = trackId;
    }

    public UUID getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public void setTrackId(UUID trackId) {
        this.trackId = trackId;
    }
}
