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

import com.example.MovieBookingApplication.DTO.MoviesDTO;
import com.example.MovieBookingApplication.DTO.TheatreDTO;
import com.example.MovieBookingApplication.Entity.Theatre;
import com.example.MovieBookingApplication.Service.TheatreService;

@RestController
@RequestMapping("/api/theatre")
public class TheatreController {

  @Autowired
  public TheatreService theatreService;

  @PostMapping("/addtheatre")
  public ResponseEntity<Theatre> addtheatre(@RequestBody TheatreDTO theatreDTO) {
    return ResponseEntity.ok(theatreService.addtheatre(theatreDTO));
  }

  @GetMapping("/getalltheatre")
  public ResponseEntity<List<Theatre>> getAllTheatre(@RequestParam String location) {
    return ResponseEntity.ok(theatreService.getAllTheatre(location));
  }

  @PutMapping("/updatemovie")
  @PreAuthorize("haseRole('ADMIN')")
  public ResponseEntity<Theatre> updateTheatre(@PathVariable Long id, @RequestBody TheatreDTO theatreDTO) {
    return ResponseEntity.ok(theatreDTO.updateTheatre(id, theatreDTO));
  }

  @DeleteMapping("/deletemapping/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> deleteTheatre(@PathVariable Long id) {
    theatreService.deleteTheatre(id);
    return ResponseEntity.ok().build();

  }
}
