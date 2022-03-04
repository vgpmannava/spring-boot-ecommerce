package com.vgpmdb.moviecatalogservice.controller;

import com.vgpmdb.moviecatalogservice.entity.Catalog;
import com.vgpmdb.moviecatalogservice.entity.Movie;
import com.vgpmdb.moviecatalogservice.entity.Rating;
import com.vgpmdb.moviecatalogservice.entity.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    // REST Template is used to call resource from another microservice. RESTTemplate is synchronous
    // Webclient is the alternative for REST template. Webclient is asynchronous. This is part of Spring Reactice
    // Using Spring Bean to create RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<Catalog> readMovieCatalogForUser(@PathVariable("userId") String userId){

        // REST Template is used to call resource from another microservice
        // Webclient is the alternative for REST template
        // RestTemplate restTemplate = new RestTemplate();

        // Sample data of the ratings we have
        /*List<Rating> ratings = Arrays.asList(
                new Rating(1, "4"),
                new Rating(2, "3.5"));*/

        UserRating userRating = restTemplate.getForObject("http://localhost:8082/ratingsdata/user/"+userId, UserRating.class);

        // For the movies which have rating, read the movie using the movie id. Here we are calling a different service movie info service
        // This gives the movie info and set that to the catalog.
        return userRating.getRatings().stream().map(rating -> {

            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);

            /*Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/

            return new Catalog(1, movie.getName(), "Description", rating.getRating());
        }).collect(Collectors.toList());



       /* return Arrays.asList(new Catalog(1, "Transformers", "Transformers", "4"),
                             new Catalog(2, "Gladiator", "Gladiator", "4.5"));*/
    }

}
