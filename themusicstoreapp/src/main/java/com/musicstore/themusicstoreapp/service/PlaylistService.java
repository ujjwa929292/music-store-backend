package com.musicstore.themusicstoreapp.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.musicstore.themusicstoreapp.accessors.models.Playlist;
import com.musicstore.themusicstoreapp.accessors.models.PlaylistTrack;
import com.musicstore.themusicstoreapp.accessors.repositories.PlaylistRepository;
import com.musicstore.themusicstoreapp.accessors.repositories.PlaylistTrackRepository;
import com.musicstore.themusicstoreapp.exceptions.ResourceNotFoundException;
import com.musicstore.themusicstoreapp.models.PlaylistDTO;
import com.musicstore.themusicstoreapp.models.PlaylistTrackId;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final ModelMapper modelMapper;
    private final PlaylistTrackRepository playlistTrackRepository;

    public Playlist createPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = modelMapper.map(playlistDTO, Playlist.class);
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(UUID id, PlaylistDTO playlistDTO) {
        Playlist existingPlaylist = getPlaylistById(id);
        modelMapper.map(playlistDTO, existingPlaylist);
        return playlistRepository.save(existingPlaylist);
    }

    public void deletePlaylist(UUID id) {
        playlistRepository.deleteById(id);
    }

    public Playlist getPlaylistById(UUID id) {
        return playlistRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Playlist not found"));
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public void addTrackToPlaylist(UUID playlistId, UUID trackId) {
        PlaylistTrack playlistTrack = new PlaylistTrack(playlistId, trackId);
        playlistTrackRepository.save(playlistTrack);
    }

    public void removeTrackFromPlaylist(UUID playlistId, UUID trackId) {
        playlistTrackRepository.deleteById(new PlaylistTrackId(playlistId, trackId));
    }
}
