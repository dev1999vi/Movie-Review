package dev.devendra.moviereview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document //to let the framework know it's a document
@Data //for automatic getter and setter for all the private arguments below
@AllArgsConstructor //for automatic constructor with all the below arguments
@NoArgsConstructor //for automatic constructor with no arguments
public class Movie {
    @Id //To let the framework know it's a unique id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //to let the framework know the relationship also causes the database to only store the ids of the review
    private List<Review> reviewIds;
}
