package com.musicstore.themusicstoreapp.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AlbumDTO {
    private String title;
    private String shortDescription;
    private String url;
    private String description;
    private String headline;
    private String headlineDescription;
    private String price;
    private UUID mainCategoryId;
    private UUID[] fileIds;
    private String artist;
    private LocalDateTime releaseDate;
    private String label;
}
