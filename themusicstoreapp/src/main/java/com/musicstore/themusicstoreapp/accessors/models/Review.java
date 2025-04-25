package com.musicstore.themusicstoreapp.accessors.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Updated to use GenerationType.UUID for UUID generation
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, length = 255, name = "authorname")
    private String authorName;

    @Column(nullable = false, name = "rating")
    private int rating;

    @Column(length = 255, name = "title")
    private String title;

    @Column(columnDefinition = "TEXT", name = "description")
    private String description;

    @Column(nullable = false, name = "productid")
    private UUID productId;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
