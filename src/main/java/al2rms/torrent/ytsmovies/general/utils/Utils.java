package al2rms.torrent.ytsmovies.general.utils;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

public class Utils {
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";

    /**
     * Metodo para obtener el entity con el que se llamaran todos los endpoints del api de YTS
     * @return
     */
    public static HttpEntity<String> getEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", USER_AGENT);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return entity;
    }

}
