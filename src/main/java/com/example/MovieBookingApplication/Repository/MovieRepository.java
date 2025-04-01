package com.example.MovieBookingApplication.Repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.MovieBookingApplication.Entity.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Long> {

  Optional<List<Movies>> findByGenre(String genre);

  Optional<List<Movies>> findByLanguage(String Language);

  Optional<List<Movies>> findByName(String title);

}
