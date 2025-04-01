package com.example.MovieBookingApplication.Service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieBookingApplication.DTO.TheatreDTO;
import com.example.MovieBookingApplication.Entity.Theatre;
import com.example.MovieBookingApplication.Repository.TheatreRepository;

@Service
public class TheatreService {

  @Autowired
  private TheatreRepository theatreReository;

  public Theatre addtheatre(TheatreDTO theatreDTO) {
    Theatre theater = new Theatre();
    theater.settheatreName(theatreDTO.gettheatreName());
    theater.settheatreLocation(theatreDTO.gettheatreLocation());
    theater.settheatreCapacity(theatreDTO.gettheatreCapacity());
    theater.settheatreScreenType(theatreDTO.gettheatreScreenType());

    return theatreReository.save(theater);

  }

  public List<Theatre> getTheatreByLocation(String location) {
    Optional<List<Theatre>> listofTheatreBox = theatreReository.findByLocation(location);

    if (listofTheatreBox.isPresent()) {
      return listofTheatreBox.get();

    } else
      throw new RuntimeException("OOPS : No theater Found ");
  }

  public Theatre updateTheatre(Long id, TheatreDTO theatreDTO) {
    Theatre theater = theatreReository.findById(id)
        .orElseThrow(() -> new RuntimeException("OOPS : No Thrater Found " + id));

    theater.settheatreName(theatreDTO.gettheatreName());
    theater.settheatreLocation(theatreDTO.gettheatreLocation());
    theater.settheatreCapacity(theatreDTO.gettheatreCapacity());
    theater.settheatreScreenType(theatreDTO.gettheatreScreenType());

    return theatreReository.save(theater);

  }

  public void deleteTheatre(Long id) {
    theatreReository.delete(id);
  }

}
