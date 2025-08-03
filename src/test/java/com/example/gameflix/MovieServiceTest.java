package com.example.gameflix;

import com.example.gameflix.model.Movie;
import com.example.gameflix.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        List<Movie> movies = movieService.getAllMovies();
        Assertions.assertNotNull(movies); // or use assertFalse if you expect data
    }

    @Test
    void createMovie_ShouldReturnSavedMovie() {
        Movie movie = new Movie();
        movie.setTitle("JUnit Movie");
        movie.setGenre("Action");
        movie.setYear(2025);

        Movie savedMovie = movieService.createMovie(movie);
        Assertions.assertNotNull(savedMovie.getId());
    }

    @Test
    void getMovieById_ShouldReturnCorrectMovie() {
        Movie movie = new Movie();
        movie.setTitle("Test");
        movie.setGenre("Drama");
        movie.setYear(2024);

        Movie saved = movieService.createMovie(movie);
        Movie found = movieService.getMovieById(saved.getId());

        Assertions.assertEquals("Test", found.getTitle());
    }
}
