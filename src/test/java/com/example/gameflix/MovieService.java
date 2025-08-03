package com.example.gameflix.service;

import com.example.gameflix.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private final Map<Long, Movie> movieStorage = new HashMap<>();
    private long currentId = 1;

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieStorage.values());
    }

    public Movie createMovie(Movie movie) {
        movie.setId(currentId++);
        movieStorage.put(movie.getId(), movie);
        return movie;
    }

    public Movie getMovieById(Long id) {
        return movieStorage.get(id);
    }
}
