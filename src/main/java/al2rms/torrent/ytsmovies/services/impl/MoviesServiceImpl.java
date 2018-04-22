package al2rms.torrent.ytsmovies.services.impl;

import al2rms.torrent.ytsmovies.pojo.Movie;
import al2rms.torrent.ytsmovies.repositories.MovieRepositorie;
import al2rms.torrent.ytsmovies.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    MovieRepositorie movieRepositorie;

    @Override
    @Transactional
    public Movie saveMovie(Movie movie) {

        return movieRepositorie.save(movie);
    }
}
