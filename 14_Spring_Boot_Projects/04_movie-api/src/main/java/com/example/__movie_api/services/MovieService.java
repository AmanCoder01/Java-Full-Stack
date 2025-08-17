package com.example.__movie_api.services;

import com.example.__movie_api.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie createMovie(Movie movie);
    Movie getMovieById(Long id);
    Movie updateMovie(Movie movie);
    Movie deleteById(Long id);
    List<Movie> searchMovie(String genre, Integer releaseYear);
}
