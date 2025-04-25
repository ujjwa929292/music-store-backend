package com.musicstore.themusicstoreapp.accessors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.musicstore.themusicstoreapp.accessors.models.PlaylistTrack;
import com.musicstore.themusicstoreapp.models.PlaylistTrackId;

@Repository
public interface PlaylistTrackRepository extends JpaRepository<PlaylistTrack, PlaylistTrackId> {
}
