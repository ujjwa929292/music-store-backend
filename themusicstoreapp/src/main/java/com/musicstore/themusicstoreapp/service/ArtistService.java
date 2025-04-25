package com.musicstore.themusicstoreapp.service;

import java.util.List;
import java.util.UUID;

import com.musicstore.themusicstoreapp.accessors.models.Artist;
import com.musicstore.themusicstoreapp.models.ArtistDTO;

public interface ArtistService {
    Artist createArtist(ArtistDTO artistDTO);
    Artist updateArtist(UUID id, ArtistDTO artistDTO);
    void deleteArtist(UUID id);
    Artist getArtistById(UUID id);
    List<Artist> getAllArtists();
}
