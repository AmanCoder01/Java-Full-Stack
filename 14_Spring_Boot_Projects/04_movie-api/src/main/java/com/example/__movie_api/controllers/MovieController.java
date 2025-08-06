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
    public ResponseEntity<CustomResponse<List<Movie>>> getAllMovies(){
        List<Movie> movie = movieService.getAllMovies();

        CustomResponse<List<Movie>> response;

        if(movie == null){
            response = new CustomResponse<>(false,"Movie not found !",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(new CustomResponse<>(true,"Movie fetched...",movie));
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


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Movie>> getMovieById(@PathVariable Long id){
        Movie movie = movieService.getMovieById(id);

        CustomResponse<Movie> response;

        if(movie == null){
            response = new CustomResponse<>(false,"Movie not found !",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(new CustomResponse<>(true,"movie fetched",movie));
    }

    @PutMapping
    public ResponseEntity<CustomResponse<Movie>> updateMovie(@RequestBody Movie movie){
        Movie updatedMovie = movieService.updateMovie(movie);

        CustomResponse<Movie> response;

        if(updatedMovie==null){
            response = new CustomResponse<>(false,"Movie not found !",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(new CustomResponse<>(true,"Movie updated successfully...",updatedMovie));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<Void>> deleteById(@PathVariable Long id){
        CustomResponse<Void> response;

        Movie removedMovie = movieService.deleteById(id);

        if(removedMovie == null){
            response = new CustomResponse<>(false,"Movie not found !",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(new CustomResponse<>(true,"Movie deleted successfully...",null));
    }
}
