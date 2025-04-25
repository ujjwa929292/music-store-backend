package com.musicstore.themusicstoreapp.accessors.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Use GenerationType.UUID instead of GenericGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, length = 255, name = "title")
    private String title;

    @Column(nullable = false, name = "duration")
    private int duration;

    @Column(name = "album_id", nullable = false)
    private UUID albumId;

    @Column(name = "artist_id")
    private UUID artistId;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated = LocalDateTime.now();

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public UUID getAlbumId() {
        return albumId;
    }

    public void setAlbumId(UUID albumId) {
        this.albumId = albumId;
    }

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
