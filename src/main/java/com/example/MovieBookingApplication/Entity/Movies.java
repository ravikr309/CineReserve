package com.example.MovieBookingApplication.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data

public class Movies {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private long id;
  private String name;
  private String description;
  private String genre;
  private Integer duration;
  private LocalDate releaseDate;
  private String language;

  @OneToMany(mappedBy = "movies", fetch = FetchType.LAZY)
  private List<Show> show;

}
