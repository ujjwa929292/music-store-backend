package com.musicstore.themusicstoreapp.service;

import java.util.List;
import java.util.UUID;
import com.musicstore.themusicstoreapp.accessors.models.Track;
import com.musicstore.themusicstoreapp.models.TrackDTO;

public interface TrackService {
    Track createTrack(TrackDTO trackDTO);
    Track updateTrack(UUID id, TrackDTO trackDTO);
    void deleteTrack(UUID id);
    Track getTrackById(UUID id);
    List<Track> getAllTracks();
}
