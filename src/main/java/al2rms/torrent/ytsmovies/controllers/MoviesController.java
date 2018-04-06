package al2rms.torrent.ytsmovies.controllers;

import al2rms.torrent.ytsmovies.general.utils.Utils;
import al2rms.torrent.ytsmovies.pojo.YtsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/movies")
public class MoviesController {

    private static final Logger log = LoggerFactory.getLogger(MoviesController.class);

    @GetMapping()
    public String getMovies() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<YtsResponse> response = restTemplate.exchange("https://yts.am/api/v2/list_movies.json", HttpMethod.GET, Utils.getEntity(), YtsResponse.class);
        return response.toString();
    }

    @GetMapping("/{movieId}")
    public String getMovie(@PathVariable String movieId) {
        RestTemplate restTemplate = new RestTemplate();
        Object response = restTemplate.exchange("https://yts.am/api/v2/list_movies.json", HttpMethod.GET, Utils.getEntity(), Object.class);
        log.info(response.toString());
        return response.toString();
    }
}
