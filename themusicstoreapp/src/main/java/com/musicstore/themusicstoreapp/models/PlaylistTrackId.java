package com.musicstore.themusicstoreapp.models;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistTrackId implements Serializable {
    private UUID playlistId;
    private UUID trackId;
}
