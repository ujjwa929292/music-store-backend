package com.musicstore.themusicstoreapp.models;

import java.util.UUID;

import lombok.Data;

@Data
public class TrackDTO {
    private String title;
    private int duration;
    private UUID albumId;
    private UUID artistId;
}
