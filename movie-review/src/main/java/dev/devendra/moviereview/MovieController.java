package dev.devendra.moviereview;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//This is the API layer which is concerned with only receiving the request and processing it for a response
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    //the {id} is the @PathVariable.
    @GetMapping("/{ImdbId}")
    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String ImdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(ImdbId), HttpStatus.OK);
    }
}
