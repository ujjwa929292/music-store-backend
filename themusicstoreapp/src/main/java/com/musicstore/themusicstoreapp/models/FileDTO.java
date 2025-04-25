package com.musicstore.themusicstoreapp.models;

import java.util.UUID;

import lombok.Data;

@Data
public class FileDTO {
    private String name;
    private String url;
    private String fileType;
    private String alt;
    private String thumbnailUrl;
    private UUID productId;
}
