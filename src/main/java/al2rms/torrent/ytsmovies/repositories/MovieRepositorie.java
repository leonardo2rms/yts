package al2rms.torrent.ytsmovies.repositories;

import al2rms.torrent.ytsmovies.pojo.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MovieRepositorie extends CrudRepository<Movie, String> {
}
