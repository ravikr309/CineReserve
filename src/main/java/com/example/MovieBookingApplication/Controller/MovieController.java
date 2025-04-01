package com.example.MovieBookingApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.example.MovieBookingApplication.DTO.MoviesDTO;
import com.example.MovieBookingApplication.Entity.Movies;
import com.example.MovieBookingApplication.Service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @PostMapping("/addmovie")
  @PreAuthorize("haseRole('ADMIN')")
  public ResponseEntity<Movies> addMovie(@RequestBody MoviesDTO moviesDTO) {
    return ResponseEntity.ok(movieService.addMovie(moviesDTO));

  }

  @GetMapping("/getallmovies")
  public ResponseEntity<List<Movies>> getAllMovies() {
    return ResponseEntity.ok(movieService.getAllMovies());
  }

  @GetMapping("/getmoviesbygenre")
  public ResponseEntity<List<Movies>> getMoviesByGenre(@RequestParam String genre) {
    return ResponseEntity.ok(movieService.getMoviesByGenre(genre));

  }

  @GetMapping("/getmoviesbylanguage")
  public ResponseEntity<List<Movies>> getMoviesByLanguage(@RequestParam String language) {
    return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
  }

  @GetMapping(".getmoviesbytitle")
  public ResponseEntity<List<Movies>> getMoviesByTitle(@RequestParam String title) {
    return ResponseEntity.ok(movieService.getMoviesByTitle(title));
  }

  // here change the movie type to object and added the update method in the DTO
  @PutMapping("/updatemovie")
  @PreAuthorize("haseRole('ADMIN')")
  public ResponseEntity<Object> updateMovie(@PathVariable Long id, @RequestBody MoviesDTO moviesDTO) {
    return ResponseEntity.ok(moviesDTO.updateMovie(id, moviesDTO));
  }

  @DeleteMapping("/deletemovie/{id}")
  @PreAuthorize("haseRole('ADMIN')")
  public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
    movieService.deleteMovie(id);

    return ResponseEntity.ok().build();
  }

}
