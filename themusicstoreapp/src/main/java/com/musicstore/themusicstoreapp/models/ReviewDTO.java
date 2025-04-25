package com.musicstore.themusicstoreapp.models;

import lombok.Data;

@Data
public class ReviewDTO {
    private String authorName;
    private int rating;
    private String title;
    private String description;
}
