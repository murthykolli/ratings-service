package com.selfpro.tmdb.repo;

import com.selfpro.tmdb.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    //Here no need of Public because of Interface by default public
    Rating findByName(String name);

    List<Rating> findAllByAvgRatingBetween(double min, double max);
}
