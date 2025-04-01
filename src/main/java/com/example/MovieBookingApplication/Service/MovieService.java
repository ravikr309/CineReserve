package com.example.MovieBookingApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MovieBookingApplication.DTO.MoviesDTO;
import com.example.MovieBookingApplication.Entity.Movies;
import com.example.MovieBookingApplication.Repository.MovieRepository;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  public Movies addMovie(MoviesDTO moviesDTO) {
    Movies movies = new Movies();
    movies.setName(moviesDTO.getName());
    movies.setDescription(moviesDTO.getDescription());
    movies.setGenre(moviesDTO.getGenre());
    movies.setReleaseDate(moviesDTO.getReleaseDate());
    movies.setDuration(moviesDTO.getDuration());
    movies.setLanguage(moviesDTO.getLanguage());

    return movieRepository.save(movies);

  }

  public List<Movies> getAllMovies() {
    return movieRepository.findAll();
  }

  public List<Movies> getMoviesByGenre(String genre) {
    Optional<List<Movies>> ListofMovieBox = movieRepository.findByGenre(genre);

    if (ListofMovieBox.isPresent()) {
      return ListofMovieBox.get();
    } else
      throw new RuntimeException("Oops : Movies Doesn't Found " + genre);
  }

  public List<Movies> getMoviesByLanguage(String language) {
    Optional<List<Movies>> ListofMovieBox = movieRepository.findByLanguage(language);

    if (ListofMovieBox.isPresent()) {
      return ListofMovieBox.get();
    } else
      throw new RuntimeException("Oops : Movies Doesn't Found " + language);

  }

  public List<Movies> getMoviesByTitle(String title) {
    Optional<List<Movies>> ListofMovieBox = movieRepository.findByName(title);

    if (ListofMovieBox.isPresent()) {
      return ListofMovieBox.get();
    } else
      throw new RuntimeException("Oops : Movies Doesn't Found " + title);

  }

  public Movies updateMovie(Long id, MoviesDTO moviesDTO) {
    Movies movies = movieRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No Movies for the id" + id));

    movies.setName(moviesDTO.getName());
    movies.setDescription(moviesDTO.getDescription());
    movies.setGenre(moviesDTO.getGenre());
    movies.setReleaseDate(moviesDTO.getReleaseDate());
    movies.setDuration(moviesDTO.getDuration());
    movies.setLanguage(moviesDTO.getLanguage());

    return movieRepository.save(movies);

  }

  public void deleteMovie(long id) {
    movieRepository.deleteById(id);

  }

}
