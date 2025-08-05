package com.example.__movie_api.services.impl;

import com.example.__movie_api.models.Movie;
import com.example.__movie_api.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}
