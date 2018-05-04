package al2rms.torrent.ytsmovies.controllers;

import al2rms.torrent.ytsmovies.general.utils.Utils;
import al2rms.torrent.ytsmovies.pojo.Movie;
import al2rms.torrent.ytsmovies.pojo.YtsResponse;
import al2rms.torrent.ytsmovies.repositories.MovieRepositorie;
import al2rms.torrent.ytsmovies.services.MoviesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RestController()
@RequestMapping("/movies")
public class MoviesController {

    private static final Logger log = LoggerFactory.getLogger(MoviesController.class);

    @Autowired
    MoviesService moviesService;
    @Autowired
    MovieRepositorie movieRepositorie;

    RestTemplate restTemplate = new RestTemplate();


    @GetMapping()
    public YtsResponse getMovies() {
        ResponseEntity<YtsResponse> response = restTemplate.exchange("https://yts.am/api/v2/list_movies.json", HttpMethod.GET, Utils.getEntity(), YtsResponse.class);
        return response.getBody();
    }

    @GetMapping("/{movieId}")
    public String getMovie(@PathVariable String movieId) {
        Object response = restTemplate.exchange("https://yts.am/api/v2/list_movies.json", HttpMethod.GET, Utils.getEntity(), Object.class);
        log.info(response.toString());
        return response.toString();
    }

    @PostMapping()
    public Movie saveMovie(@RequestBody Movie movie) {
        return moviesService.saveMovie(movie);
    }

    @GetMapping("/run")
    public List<Movie> fillDatabase() {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        List<Movie> peliculasGuardadas = new ArrayList<>();
        IntStream.range(1, 370).forEach(i -> {
            executorService.execute(() -> {
                ResponseEntity<YtsResponse> response = restTemplate.exchange("https://yts.am/api/v2/list_movies.json?page=" + i, HttpMethod.GET, Utils.getEntity(), YtsResponse.class);
                movieRepositorie.saveAll(response.getBody().getData().getMovies());
                System.out.println("Guardada pagina: " + i);
            });
        });
        movieRepositorie.findAll().forEach(peliculasGuardadas::add);
        return peliculasGuardadas;
    }
}
