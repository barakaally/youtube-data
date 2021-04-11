package youtube.data.yt.core;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
/**
 * @description the Inet
 */
public abstract class Inet {
    /**
     * 
     * @return String return the public IpAddress of Machine
     */
    static public String getHost() {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format("http://checkip.amazonaws.com/"))).build();

            return client.send(request, BodyHandlers.ofString()).body();
            
        } catch (Exception e) {

            return "127.0.0.1";
        }

    }
}
