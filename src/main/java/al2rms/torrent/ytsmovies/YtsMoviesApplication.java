package al2rms.torrent.ytsmovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class YtsMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtsMoviesApplication.class, args);
	}
}
