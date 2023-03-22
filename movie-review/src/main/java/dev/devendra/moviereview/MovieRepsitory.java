package dev.devendra.moviereview;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//The repository does the actual talking to the database
@Repository //To let the framework know it's a Repository
public interface MovieRepsitory extends MongoRepository<Movie, ObjectId> {
    //MongoDB is smart enough to generate the query by itself
    Optional<Movie> findMovieByImdbId(String ImdbId);
}
