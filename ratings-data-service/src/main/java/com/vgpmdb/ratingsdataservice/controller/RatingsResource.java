package com.vgpmdb.ratingsdataservice.controller;

import com.vgpmdb.ratingsdataservice.entity.Rating;
import com.vgpmdb.ratingsdataservice.entity.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){

        return new Rating(180, "4");
    }

    // Best Practice is not to return List. Instead return a wrapper object .
    // Here instead of returning List<Rating> returning UserRating which has List<Property>
    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String movieId){

        UserRating userRating = new UserRating();

        userRating.setRatings(Arrays.asList(
                new Rating(280, "4"),
                new Rating(575, "3")));
        return userRating;
    }
}
