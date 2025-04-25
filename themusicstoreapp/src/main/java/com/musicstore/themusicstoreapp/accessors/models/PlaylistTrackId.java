package com.musicstore.themusicstoreapp.accessors.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class PlaylistTrackId implements Serializable {

    private UUID playlistId;
    private UUID trackId;

    // Default constructor
    public PlaylistTrackId() {}

    // All-args constructor
    public PlaylistTrackId(UUID playlistId, UUID trackId) {
        this.playlistId = playlistId;
        this.trackId = trackId;
    }

    // Getters and setters (optional if using Lombok)

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

    // equals and hashCode (required for JPA composite key)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaylistTrackId)) return false;
        PlaylistTrackId that = (PlaylistTrackId) o;
        return Objects.equals(playlistId, that.playlistId) &&
               Objects.equals(trackId, that.trackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, trackId);
    }
}
