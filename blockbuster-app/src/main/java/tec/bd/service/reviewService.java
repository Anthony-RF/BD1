package tec.bd.service;


import java.util.List;
import java.util.Optional;
import tec.bd.entity.reviewEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static java.util.Objects.requireNonNull;

public interface reviewService {

    List<reviewEntity> getReviews();

    Optional<reviewEntity> getReviewById(int reviewId);

    reviewEntity newReview(reviewEntity newReview);

    void removeReview(int reviewId);

    reviewEntity updateReview(reviewEntity review);
    void printReview (reviewEntity review);

}