package com.musicstore.themusicstoreapp.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.themusicstoreapp.accessors.models.Review;
import com.musicstore.themusicstoreapp.accessors.models.Product;
import com.musicstore.themusicstoreapp.accessors.repositories.ReviewRepository;
import com.musicstore.themusicstoreapp.accessors.repositories.ProductRepository;
import com.musicstore.themusicstoreapp.exceptions.ResourceNotFoundException;
import com.musicstore.themusicstoreapp.models.ReviewCreateDTO;
import com.musicstore.themusicstoreapp.models.ReviewDTO;
import com.musicstore.themusicstoreapp.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ReviewDTO createReview(UUID productId, ReviewDTO reviewDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Review review = modelMapper.map(reviewDTO, Review.class);
        review.setProduct(product);

        Review savedReview = reviewRepository.save(review);
        return modelMapper.map(savedReview, ReviewDTO.class);
    }

    @Override
    public List<ReviewDTO> getReviewsByProductId(UUID productId) {
        return reviewRepository.findByProductId(productId)
                .stream()
                .map(review -> modelMapper.map(review, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO updateReview(UUID id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));

        modelMapper.map(reviewDTO, review);
        Review updatedReview = reviewRepository.save(review);
        return modelMapper.map(updatedReview, ReviewDTO.class);
    }

    @Override
    public void deleteReview(UUID id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public ReviewDTO getReviewById(UUID id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
        return modelMapper.map(review, ReviewDTO.class);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(review -> modelMapper.map(review, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReviewsByProductId(UUID productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        log.info("Number of reviews before deletion: {}", reviews.size());

        reviewRepository.deleteByProductId(productId);

        List<Review> remaining = reviewRepository.findByProductId(productId);
        log.info("Number of reviews after deletion: {}", remaining.size());
    }

    @Override
    public List<ReviewDTO> bulkCreateReviewsbyProductId(UUID productId, List<ReviewCreateDTO> reviewDTOs) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        List<Review> reviews = reviewDTOs.stream()
                .map(dto -> {
                    Review review = modelMapper.map(dto, Review.class);
                    review.setProduct(product);
                    return review;
                })
                .collect(Collectors.toList());

        List<Review> saved = reviewRepository.saveAll(reviews);

        return saved.stream()
                .map(r -> modelMapper.map(r, ReviewDTO.class))
                .collect(Collectors.toList());
    }
}
