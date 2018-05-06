package al2rms.torrent.ytsmovies.pojo;

import java.util.List;

/**
 * Clase que representa la data obtenida de YTS response
 *
 * @author ldosramos
 */
public class DataYts {

    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
