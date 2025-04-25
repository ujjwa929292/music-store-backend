package com.musicstore.themusicstoreapp.accessors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import com.musicstore.themusicstoreapp.accessors.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByProductId(UUID productId);
}
