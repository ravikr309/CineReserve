package com.example.MovieBookingApplication.Entity;

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
public class Theatre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String theatreName;
  private String theatreLocation;
  private String theatreCapacity;
  private String theatreScreenType;

  @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY)
  private List<Show> show;

}
