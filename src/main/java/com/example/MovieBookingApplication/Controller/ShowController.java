package com.example.MovieBookingApplication.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieBookingApplication.DTO.ShowDTO;
import com.example.MovieBookingApplication.Entity.Show;
import com.example.MovieBookingApplication.Service.ShowService;

@RestController
@RequestMapping("/api/show")
public class ShowController {

  @Autowired
  private ShowService showService;

  @PostMapping("/createshow")
  public ResponseEntity<Show> createShow(@RequestBody ShowDTO showDTO) {
    return ResponseEntity.ok(showService.createShow(showDTO));
  }

  @GetMapping("/getallshows")
  public ResponseEntity<List<Show>> getAllShows() {
    return ResponseEntity.ok(showService.getALlShows());
  }

  @GetMapping("/getshowsbymovies")
  public ResponseEntity<List<Show>> getShowByMovie(@RequestParam string movies) {
    return ResponseEntity.ok(showService.getShowByMovie(movies));

  }

  @GetMapping("/getshowsbymovies")
  public ResponseEntity<List<Show>> getShowByMovie(@RequestParam string theatre) {
    return ResponseEntity.ok(showService.getShowByMovie(theatre));

  }

  @PutMapping("/updateshow/{id}")
  public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestParam ShowDTO showDTO) {
    return ResponseEntity.ok(showService.updateShow(id, showDTO));
  }

  @DeleteMapping("/deleteshow/{id}")
  public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
    showService.deleteShow(id);
    return ResponseEntity.ok().build();

  }

}
