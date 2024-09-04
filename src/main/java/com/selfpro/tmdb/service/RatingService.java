package com.selfpro.tmdb.service;

import com.selfpro.tmdb.exception.NotFoundException;
import com.selfpro.tmdb.model.Rating;
import com.selfpro.tmdb.repo.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    public Rating updateAvg(String name, double stats) {
        Rating rating = ratingRepository.findByName(name);
        if(rating == null) {
//            throw new RuntimeException("Movie not found with name: "+name);
            rating = new Rating();
            rating.setName(name);
            rating.setAvgRating(stats);
            rating.setCount(1);
        } else {
            int count = rating.getCount();
            double newAverage = (rating.getAvgRating() * count + stats) / (count + 1);
            rating.setAvgRating(newAverage);
            rating.setCount(++count);
        }
        return ratingRepository.save(rating);
    }

    public Rating fetchRating (String name) {
        Rating rating = ratingRepository.findByName(name);
        if(rating == null) {
            throw new NotFoundException("Movie not found with name: "+ name);
        }
        return rating;
    }
}
