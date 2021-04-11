package youtube.data.yt.core;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

 public class Client {

    public static CompletableFuture<HttpResponse<String>>  getVideoInfoAsync(String videoId){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId) ))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }

    public static HttpResponse<String>  getVideoInfo(String videoId) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }

    public static CompletableFuture<HttpResponse<String>> getPlayerJsAsync(){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/") ))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }

    public static HttpResponse<String>  getPlayerJs() throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/") ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }

    public static CompletableFuture<HttpResponse<String>> getYtPlayerDecoderAsync(String jsUrl){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(jsUrl))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }

    public static HttpResponse<String>  getYtPlayerDecipher(String jsUrl) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format(jsUrl) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }
}
