package com.example.MovieBookingApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieBookingApplication.DTO.ShowDTO;
import com.example.MovieBookingApplication.Entity.Booking;
import com.example.MovieBookingApplication.Entity.Movies;
import com.example.MovieBookingApplication.Entity.Show;
import com.example.MovieBookingApplication.Entity.Theatre;
import com.example.MovieBookingApplication.Repository.MovieRepository;
import com.example.MovieBookingApplication.Repository.ShowRepository;
import com.example.MovieBookingApplication.Repository.TheatreRepository;

@Service
public class ShowService {

  @Autowired
  private ShowRepository showRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private TheatreRepository theatreRepository;

  public Show createShow(ShowDTO showDTO) {
    Movies movies = movieRepository.findById(showDTO.getMoviesId())
        .orElseThrow(() -> new RuntimeException("Oops : No Movie found " + showDTO.getMoviesId()));

    Theatre theatre = theatreRepository.findById(showDTO.getTheatreById())
        .orElseThrow(() -> new RuntimeException("Oops : No theatre Found" + showDTO.getTheatreById()));

    Show show = new Show();
    show.setShowTime(showDTO.getShowTime());
    show.setPrice(showDTO.getPrice());
    show.setMovies(movies);
    show.setTheatre(theatre);

    return showRepository.save(show);

  }

  public List<Show> getAllShows() {
    return showRepository.findAll();
  }

  public List<Show> getShowByMovie(Long movieid) {
    Optional<List<Show>> showListBox = showRepository.findByMovieId(movieid);

    if (showListBox.isPresent()) {
      return showListBox.get();

    } else
      throw new RuntimeException("No Shows available");

  }

  public List<Show> getShowByTheatre(Long theatreid) {
    Optional<List<Show>> showListBox = showRepository.findByTheatreId(theatreid);

    if (showListBox.isPresent()) {
      return showListBox.get();

    } else
      throw new RuntimeException("No Shows available");

  }

  public Show updateShow(Long id, ShowDTO showDTO) {
    Show show = showRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Oops : "));

    Movies movies = movieRepository.findById(showDTO.getMoviesId())
        .orElseThrow(() -> new RuntimeException("Oops : No Movie found " + showDTO.getMoviesId()));

    Theatre theatre = theatreRepository.findById(showDTO.getTheatreById())
        .orElseThrow(() -> new RuntimeException("Oops : No theatre Found" + showDTO.getTheatreById()));

    show.setShowTime(showDTO.getShowTime());
    show.setPrice(showDTO.getPrice());
    show.setMovies(movies);
    show.setTheatre(theatre);

    return showRepository.save(show);

  }

  public void deleteShow(long id) {
    if (showRepository.existsById(id)) {
      throw new RuntimeException("No show Available " + id);
    }
    List<Booking> bookings = showRepository.findById(id).get().getBooking();
    if (bookings.isEmpty()) {
      throw new RuntimeException("Cannot delete");

    }
    showRepository.deleteById(id);
  }

}
