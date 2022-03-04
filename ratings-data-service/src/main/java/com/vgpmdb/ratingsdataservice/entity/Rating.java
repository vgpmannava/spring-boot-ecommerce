package com.vgpmdb.ratingsdataservice.entity;

import lombok.Data;

@Data
public class Rating {

    private int movieId;
    private String rating;

    public Rating(int movieId, String rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}
