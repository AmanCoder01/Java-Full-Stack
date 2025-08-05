package com.example.__movie_api.controllers;

import com.example.__movie_api.dto.CustomResponse;
import com.example.__movie_api.models.Movie;
import com.example.__movie_api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movie = movieService.getAllMovies();

        if(movie == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(movie);
    }


    @PostMapping
    public ResponseEntity<CustomResponse<Movie>> createMovie(@RequestBody Movie movie){
        Movie savedMovie = movieService.createMovie(movie);

        CustomResponse<Movie> response = new CustomResponse<>(
                true,
                "Movie added successfully",
                movie
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
