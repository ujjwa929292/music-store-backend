package com.musicstore.themusicstoreapp.accessors.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Replaced GenericGenerator with GenerationType.UUID
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, length = 255, name = "name")
    private String name;

    @Column(columnDefinition = "TEXT", name = "bio")
    private String bio;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
