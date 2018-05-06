package al2rms.torrent.ytsmovies.controllers;

import al2rms.torrent.ytsmovies.general.utils.Utils;
import al2rms.torrent.ytsmovies.pojo.DataYts;
import al2rms.torrent.ytsmovies.pojo.Movie;
import al2rms.torrent.ytsmovies.pojo.YtsResponse;
import al2rms.torrent.ytsmovies.repositories.MovieRepositorie;
import al2rms.torrent.ytsmovies.services.MoviesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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

    @Autowired
    MoviesService moviesService;
    @Autowired
    MovieRepositorie movieRepositorie;

    RestTemplate restTemplate = new RestTemplate();

    private static final Logger log = LoggerFactory.getLogger(MoviesController.class);

    @GetMapping("/")
    public YtsResponse getMovies(YtsResponse response, DataYts data) {
        List<Movie> movies = (List<Movie>) movieRepositorie.findAll();
        data.setMovies(movies);
        response.setData(data);
        return response;
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable Integer movieId) {
        return movieRepositorie.findById(movieId).orElse(null);
    }

    @PostMapping()
    public Movie saveMovie(@RequestBody Movie movie) {
        return moviesService.saveMovie(movie);
    }

    @GetMapping("/run")
    public ResponseEntity<List<Movie>> fillDatabase() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<Movie> peliculasGuardadas = new ArrayList<>();
        IntStream.range(1, 300).forEach(i -> {
            executorService.execute(() -> {
                ResponseEntity<YtsResponse> response = restTemplate.exchange("https://yts.am/api/v2/list_movies.json?page=" + i, HttpMethod.GET, Utils.getEntity(), YtsResponse.class);
                List<Movie> movies = response.getBody().getData().getMovies();

                movieRepositorie.saveAll(movies);
                log.info("Guarde la pagina " + i);
            });
        });
        movieRepositorie.findAll().forEach(peliculasGuardadas::add);
        return new ResponseEntity<List<Movie>>(peliculasGuardadas, HttpStatus.OK);
    }
}
