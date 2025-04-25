package com.musicstore.themusicstoreapp.accessors.models;

import java.time.LocalDateTime;
import java.util.UUID;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Replaced GenericGenerator with GenerationType.UUID
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, length = 255, name = "title")
    private String title;

    @Column(columnDefinition = "TEXT", name = "shortdescription")
    private String shortDescription;

    @Column(length = 255, name = "url")
    private String url;

    @Column(columnDefinition = "TEXT", name = "description")
    private String description;

    @Column(length = 255, name = "headline")
    private String headline;

    @Column(length = 255, name = "headlinedescription")
    private String headlineDescription;

    @Column(length = 1000, name = "price")
    private String price;

    @Column(name = "maincategory_id")
    private UUID mainCategoryId;

    @Column(name = "fileids")
    private UUID[] fileIds;

    @Column(length = 255, name = "artist")
    private String artist;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(length = 255, name = "label")
    private String label;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated = LocalDateTime.now();

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }
}
