package com.example.__movie_api.services.impl;

import com.example.__movie_api.models.Movie;
import com.example.__movie_api.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    Map<Long,Movie> movieDb = new HashMap<>();

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieDb.values());
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieDb.put(movie.getId(), movie);
    }

    @Override
    public Movie getMovieById(Long id) {
       return movieDb.get(id);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie exitedMovie = movieDb.get(movie.getId());

        if(exitedMovie == null){
            return null;
        }
       return movieDb.put(exitedMovie.getId(),movie);
    }

    @Override
    public Movie deleteById(Long id) {
       return movieDb.remove(id);
    }

    @Override
    public List<Movie> searchMovie(String genre, Integer releaseYear) {
        return movieDb.values().stream()
                .filter(movie -> genre == null || movie.getGenre().equalsIgnoreCase(genre))
                .filter(movie -> releaseYear == null || movie.getReleaseYear() == releaseYear)
                .collect(Collectors.toList());
    }
}
