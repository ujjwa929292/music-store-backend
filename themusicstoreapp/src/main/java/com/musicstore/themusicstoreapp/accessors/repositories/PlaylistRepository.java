package com.musicstore.themusicstoreapp.accessors.repositories;

import com.musicstore.themusicstoreapp.accessors.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, UUID> {
}
