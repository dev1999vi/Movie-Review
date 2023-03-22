package dev.devendra.moviereview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//In service class we write all our business logic and it talks to the database and returns it to API layer
@Service
public class MovieService {
    @Autowired //To let the framework know we want this class instantiated here.
    private MovieRepsitory movieRepsitory;
    public List<Movie> allMovies(){
        return movieRepsitory.findAll();
    }
    //The Optional part represents that the movie object may or may not exist.
    public Optional<Movie> singleMovie(String ImdbId){
        return movieRepsitory.findMovieByImdbId(ImdbId);
    }
}
