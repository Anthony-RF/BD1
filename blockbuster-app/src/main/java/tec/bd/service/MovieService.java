package tec.bd.service;


import java.util.List;
import java.util.Optional;
import tec.bd.entity.movieEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tec.bd.entity.movieEntity;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//import tec.bd.movies.repository.MovieRepository;
import static java.util.Objects.requireNonNull;
public interface MovieService {

    List<movieEntity> getMovies();

    Optional<movieEntity> getMovieById(int movieId);

    movieEntity newMovie(movieEntity movie);

    void removeMovie(int movieId);

    movieEntity updateMovie(movieEntity movie);
    void printMovie(movieEntity movie);

}
