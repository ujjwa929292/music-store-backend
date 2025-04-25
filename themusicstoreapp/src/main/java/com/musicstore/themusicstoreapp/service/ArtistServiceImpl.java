package com.musicstore.themusicstoreapp.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.musicstore.themusicstoreapp.accessors.models.Artist;
import com.musicstore.themusicstoreapp.accessors.repositories.ArtistRepository;
import com.musicstore.themusicstoreapp.exceptions.ResourceNotFoundException;
import com.musicstore.themusicstoreapp.models.ArtistDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;

    @Override
    public Artist createArtist(ArtistDTO artistDTO) {
        Artist artist = modelMapper.map(artistDTO, Artist.class);
        return artistRepository.save(artist);
    }

    @Override
    public Artist updateArtist(UUID id, ArtistDTO artistDTO) {
        Artist existingArtist = getArtistById(id);
        modelMapper.map(artistDTO, existingArtist);
        return artistRepository.save(existingArtist);
    }

    @Override
    public void deleteArtist(UUID id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Artist getArtistById(UUID id) {
        return artistRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
}
