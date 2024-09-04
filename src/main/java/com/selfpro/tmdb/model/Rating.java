package com.selfpro.tmdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double avgRating;
    private int count;

}
