/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.service;

import java.util.List;
import java.util.Optional;
import tec.bd.entity.movieEntity;

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
import tec.bd.repository.MovieRepository;
/**
 *
 * @author Yarman
 */
public class MovieServiceImpl implements MovieService {
    
    
    private final FeatureFlags featureFlags;
    private final MovieRepository movieRepository;
    public MovieServiceImpl(MovieRepository movieRepository, FeatureFlags featureFlags){
        requireNonNull(movieRepository);
        requireNonNull(featureFlags);
        this.featureFlags=featureFlags;
        this.movieRepository = movieRepository;
       
        
    }
    @Override
    public List<movieEntity> getMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Optional<movieEntity> getMovieById(int movieId) {
       return this.movieRepository.findById(movieId);
    }

    @Override
    public movieEntity newMovie(movieEntity movie) {
         requireNonNull(movie);
        System.out.println("Creating movie...");
        var newMovieID = this.movieRepository.save(movie);
        System.out.println("New client created with ID "+newMovieID);
        // Falta Cambiar este metodo
        movie.setId(newMovieID);
        return movie;
    }

    @Override
    public void removeMovie(int movieId) {
          requireNonNull(movieId);
        System.out.println("Deleting movie");
        this.movieRepository.delete(movieId);
    }

    @Override
    public movieEntity updateMovie(movieEntity movie) {
       requireNonNull(movie);
        this.movieRepository.update(movie);
        return movie;
    }
     @Override
    public void printMovie(movieEntity movie){
        System.out.println(
        "Movie ID: " + movie.getId()+
                "\nMovie Title: " +movie.getTitle()
                +"\nCategory ID " +movie.getCategoryID()+
                "Units Available " +movie.getUnits_available()
        );
    }
    
}
