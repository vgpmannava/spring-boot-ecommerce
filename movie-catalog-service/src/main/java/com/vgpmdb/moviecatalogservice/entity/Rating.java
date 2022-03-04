package com.vgpmdb.moviecatalogservice.entity;

import lombok.Data;

@Data
public class Rating {

    private int movieId;
    private String rating;

    public Rating() {
    }

    public Rating(int movieId, String rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}
