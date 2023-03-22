package dev.devendra.moviereview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    //Template is used to create complex queries
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String ImdbId){
        Review review=reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("ImdbId").is(ImdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
