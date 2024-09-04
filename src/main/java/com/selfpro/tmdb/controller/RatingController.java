package com.selfpro.tmdb.controller;

import com.selfpro.tmdb.model.Rating;
import com.selfpro.tmdb.model.RatingRequest;
import com.selfpro.tmdb.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@Slf4j
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/{name}")
    public ResponseEntity<Rating> getRating(@PathVariable String name) {
        Rating rating = ratingService.fetchRating(name);
        log.info("Return rating for movie: {}", name);
        return ResponseEntity.ok(rating);
    }

    @PostMapping
    public ResponseEntity<Rating> updateRating(@RequestBody RatingRequest request) {
        Rating rating = ratingService.updateAvg(request.getName(), request.getStars());
        log.info("Return new average for movie: {}"+ rating.getAvgRating()+"_____ MOvie: "+request.getName());
        return ResponseEntity.ok(rating);
    }
}
