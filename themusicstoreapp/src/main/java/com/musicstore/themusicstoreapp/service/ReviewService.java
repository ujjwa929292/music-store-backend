package com.musicstore.themusicstoreapp.service;

import java.util.List;
import java.util.UUID;

import com.musicstore.themusicstoreapp.accessors.models.Review;
import com.musicstore.themusicstoreapp.models.ReviewDTO;

public interface ReviewService {
    Review createReview(ReviewDTO reviewDTO);
    Review updateReview(UUID id, ReviewDTO reviewDTO);
    void deleteReview(UUID id);
    Review getReviewById(UUID id);
    List<Review> getAllReviews();
    List<Review> getReviewsByProductId(UUID productId);
}
