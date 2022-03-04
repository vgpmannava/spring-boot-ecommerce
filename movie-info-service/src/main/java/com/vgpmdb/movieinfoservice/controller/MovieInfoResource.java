package com.vgpmdb.movieinfoservice.controller;

import com.vgpmdb.movieinfoservice.entity.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){

       return new Movie(1, "Transformers");
    }
}
