/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.service;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.List;
import java.util.Optional;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//import tec.bd.movies.repository.MovieRepository;
import static java.util.Objects.requireNonNull;
import tec.bd.entity.reviewEntity;
import tec.bd.entity.clientEntity;
import tec.bd.repository.rentalRepository;
import tec.bd.repository.clientRepository;
import tec.bd.repository.reviewRepository;
/**
 *
 * @author Yarman
 */
public class reviewServiceImpl implements reviewService {
    
    private final FeatureFlags featureFlags;
    private final reviewRepository ReviewRepository;
    
    public reviewServiceImpl(reviewRepository ReviewRepository , FeatureFlags featureFlags){
        requireNonNull(ReviewRepository);
        requireNonNull(featureFlags);
        this.featureFlags=featureFlags;
        this.ReviewRepository = ReviewRepository;
       
        
    }

    @Override
    public List<reviewEntity> getReviews() {
        return this.ReviewRepository.findAll();
    }

    @Override
    public Optional<reviewEntity> getReviewById(int reviewId) {
         return this.ReviewRepository.findById(reviewId);
         
         
        
    }

    @Override
    public reviewEntity newReview(reviewEntity review) {
        requireNonNull(review);
        System.out.println("Creating review...");
        var newReviewID = this.ReviewRepository.save(review);
        System.out.println("New client rental with ID "+newReviewID);
        // Falta Cambiar este metodo
        review.setID(newReviewID);
        return review;
    }

    @Override
    public void removeReview(int reviewId) {
        requireNonNull(reviewId);
        System.out.println("Deleting review");
        this.ReviewRepository.delete(reviewId);

    }

    @Override
    public reviewEntity updateReview(reviewEntity review) {
        requireNonNull(review);
        this.ReviewRepository.update(review);
        return review;
    }
    @Override
    public void printReview(reviewEntity review){
        System.out.println(
        "Review ID: " + review.getID()+
                "\nReview Date: " +review.getCreatedOn()
                +"\nClient ID " +review.getClientID()
                 +"\nMovie ID " +review.getMovieID()
                +"\nReview Text " +review.getReviewText()
                +"\nRating " +review.getRating()



        );
    }
    
}
