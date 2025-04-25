package com.musicstore.themusicstoreapp.accessors.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Use GenerationType.UUID instead of GenericGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, length = 255, name = "name")
    private String name;

    @Column(columnDefinition = "TEXT", name = "description")
    private String description;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated = LocalDateTime.now();

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
