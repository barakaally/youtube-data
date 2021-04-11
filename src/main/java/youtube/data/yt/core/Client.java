package youtube.data.yt.core;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

    public abstract  class Client {
    private String apiKey;
    public Client(){}

     public Client(String key){
         this.apiKey=key;
     }

    protected  CompletableFuture<HttpResponse<String>>  fetchVideoInfoAsync(String videoId){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId) ))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }

    protected  HttpResponse<String>  fetchVideoInfo(String videoId) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }

    protected static CompletableFuture<HttpResponse<String>> getPlayerJsAsync(){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/") ))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }

    protected static HttpResponse<String>  getPlayerJs() throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/") ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }

    protected static CompletableFuture<HttpResponse<String>> getYtPlayerDecoderAsync(String jsUrl){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(jsUrl))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }

    protected static HttpResponse<String>  getYtPlayerDecipher(String jsUrl) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format(jsUrl) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }
    
    protected  HttpResponse<String>  searchV3(String q,String channelId,int limit) throws Exception{
       if(apiKey!=null){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&channelId=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,channelId,limit,q) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
       }
       else
       {
          throw new Exception("Api Key not provided");
       }
       
    }

    protected CompletableFuture<HttpResponse<String>> searchV3Async(String q,String channelId,int limit) throws Exception{
        if(apiKey!=null){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&channelId=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,channelId,limit,q) ))
                  .build();
                  
                  return client.sendAsync(request, BodyHandlers.ofString());
           }
           else
           {
              throw new Exception("Api Key not provided");
           }
    }


    protected  HttpResponse<String>  searchV3(String q,int limit) throws Exception{
        if(apiKey!=null){
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,limit,q.replaceAll("\s","%20"))))
               .build();
               
               return client.send(request, BodyHandlers.ofString());
        }
        else
        {
           throw new Exception("Api Key not provided");
        }
        
     }

     
    protected CompletableFuture<HttpResponse<String>> searchV3Async(String q,int limit) throws Exception{
        if(apiKey!=null){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,limit,q) ))
                  .build();
                  
                  return client.sendAsync(request, BodyHandlers.ofString());
           }
           else
           {
              throw new Exception("Api Key not provided");
           }
    }
}
