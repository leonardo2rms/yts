package al2rms.torrent.ytsmovies.controllers;

import al2rms.torrent.ytsmovies.general.utils.Utils;
import al2rms.torrent.ytsmovies.pojo.YtsResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/yts/movies")
public class YtsMoviesController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public YtsResponse findAllMovies(){
        ResponseEntity<YtsResponse> response = restTemplate.exchange("https://yts.am/api/v2/list_movies.json", HttpMethod.GET, Utils.getEntity(), YtsResponse.class);
        return response.getBody();
    }
}
