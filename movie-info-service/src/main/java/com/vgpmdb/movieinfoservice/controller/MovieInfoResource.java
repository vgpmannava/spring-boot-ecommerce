package com.vgpmdb.movieinfoservice.controller;

import com.vgpmdb.movieinfoservice.entity.Movie;
import com.vgpmdb.movieinfoservice.entity.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    /*@RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){

       return new Movie("1", "Transformers","Description");
    }*/

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
     // Using REST Template
     // MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
     // return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

     // Using Web Client
        MovieSummary movieSummary = webClientBuilder.build()
                .get().uri("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey)
                .retrieve()
                .bodyToMono(MovieSummary.class)
                .block();

        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

    }
}
