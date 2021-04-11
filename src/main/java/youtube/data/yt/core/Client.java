package youtube.data.yt.core;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
    /**
     * @description the  Client
     */
    public abstract  class Client {
    private String apiKey;
     /**
      * @descrition Client's constructor
      */
     public Client(){}
     /**
      *@param key
      *@description Client's constructor
      */
     public Client(String key){
         this.apiKey=key;
     }

    /**
     * 
     * @param videoId
     * @return CompletableFuture<HttpResponse<String>> return the String of videoInfo async
     */
    protected  CompletableFuture<HttpResponse<String>>  fetchVideoInfoAsync(String videoId){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId) ))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }

   /**
    * @param videoId
    * @return HttpResponse<String> return the String of videoInfo syschrous
    * @throws IOException
    * @throws InterruptedException
    */
    protected  HttpResponse<String>  fetchVideoInfo(String videoId) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }
    /**
     * 
     * @return  CompletableFuture<HttpResponse<String>> return the String of playerJs async
     */
    protected static CompletableFuture<HttpResponse<String>> getPlayerJsAsync(){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/") ))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }
    /**
     * 
     * @return HttpResponse<String> return the String of Youtube playerJs sychronous
     * @throws IOException
     * @throws InterruptedException
     */
    protected static HttpResponse<String>  getPlayerJs() throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.youtube.com/") ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }

    /**
     * @param jsUrl
     * @return CompletableFuture<HttpResponse<String>> return the String of Youtube playerDecipher async
     */
    protected static CompletableFuture<HttpResponse<String>> getYtPlayerDecipherAsync(String jsUrl){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(jsUrl))
		      .build();
              return client.sendAsync(request, BodyHandlers.ofString());
    }
    
    /**
     * @param jsUrl
     * @return CompletableFuture<HttpResponse<String>> return the String of Youtube playerDecipher sychrounous
     */
    protected static HttpResponse<String>  getYtPlayerDecipher(String jsUrl) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format(jsUrl) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
    }

    /**
     * 
     * @param searchText
     * @param channelId
     * @param limit
     * @return HttpResponse<String> return the String of searchListResult 
     * @throws Exception
     */
    protected  HttpResponse<String>  searchV3(String searchText,String channelId,int limit) throws Exception{
       if(apiKey!=null){
        HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&channelId=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,channelId,limit,searchText.replaceAll("\s","%20")) ))
		      .build();
              
              return client.send(request, BodyHandlers.ofString());
       }
       else
       {
          throw new Exception("Api Key not provided");
       }
       
    }

    /**
     * 
     * @param searchText
     * @param channelId
     * @param limit
     * @return HttpResponse<String> return the String of searchListResult async
     * @throws Exception
     */
    protected CompletableFuture<HttpResponse<String>> searchV3Async(String searchText,String channelId,int limit) throws Exception{
        if(apiKey!=null){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&channelId=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,channelId,limit,searchText.replaceAll("\s","%20")) ))
                  .build();
                  
                  return client.sendAsync(request, BodyHandlers.ofString());
           }
           else
           {
              throw new Exception("Api Key not provided");
           }
    }

    /**
     * 
     * @param searchText
     * @param limit
     * @return HttpResponse<String> return the String of searchListResult sychronous
     * @throws Exception
     */
    protected  HttpResponse<String>  searchV3(String searchText,int limit) throws Exception{
        if(apiKey!=null){
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,limit,searchText.replaceAll("\s","%20"))))
               .build();
               
               return client.send(request, BodyHandlers.ofString());
        }
        else
        {
           throw new Exception("Api Key not provided");
        }
        
     }

     /**
     * 
     * @param searchText
     * @param limit
     * @return HttpResponse<String> return the String of searchListResult async
     * @throws Exception
     */
    protected CompletableFuture<HttpResponse<String>> searchV3Async(String searchText,int limit) throws Exception{
        if(apiKey!=null){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create(String.format("https://www.googleapis.com/youtube/v3/search?key=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,limit,searchText.replaceAll("\s","%20")) ))
                  .build();
                  
                  return client.sendAsync(request, BodyHandlers.ofString());
           }
           else
           {
              throw new Exception("Api Key not provided");
           }
    }
}
