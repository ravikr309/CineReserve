package com.example.MovieBookingApplication.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MoviesDTO {

  private long id;
  private String name;
  private String description;
  private String genre;
  private Integer duration;
  private LocalDate releaseDate;
  private String language;

  public Object updateMovie(Long id2, MoviesDTO moviesDTO) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateMovie'");
  }

}
