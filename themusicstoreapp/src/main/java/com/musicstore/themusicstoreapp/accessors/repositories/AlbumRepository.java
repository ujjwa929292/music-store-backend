package com.musicstore.themusicstoreapp.accessors.repositories;

import com.musicstore.themusicstoreapp.accessors.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {
}
