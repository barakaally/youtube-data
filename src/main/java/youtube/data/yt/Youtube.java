package youtube.data.yt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import youtube.data.yt.core.Client;
import youtube.data.niche.Response;
import youtube.data.niche.SearchListResponse;
import youtube.data.niche.VideoInfo;
import youtube.data.yt.core.Player;
import youtube.data.yt.util.YExtractor;


public class Youtube extends Client{
   
	public Youtube() {
		super();
	}
    /**
	 * 
	 * @param apiKey
	 */
	public Youtube(String apiKey) {
		super(apiKey);
	}

	public Youtube buildPlayer() {
		Player.build();
		return this;
	}
    
	/**
	 * 
	 * @param videoId
	 * @return Response return the response sychronous
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Response getVideoInfo(String videoId) throws IOException, InterruptedException {
		try {
			HttpResponse<String> response = this.fetchVideoInfo(videoId);
			return new Response(null, YExtractor.parseVideoInfo(response.body()));
		} catch (Exception e) {
			return new Response(e.getMessage(), null);
		}
	}
    
	/**
	 * 
	 * @param videoId
	 * @return CompletableFuture<Response> return the response async
	 * @throws UnsupportedEncodingException
	 */
	public CompletableFuture<Response> getVideoInfoAsync(String videoId) throws UnsupportedEncodingException {
		CompletableFuture<Response> completableFuture = new CompletableFuture<Response>();
		try {

			CompletableFuture<HttpResponse<String>> response = this.fetchVideoInfoAsync(videoId);
			VideoInfo videoInfo = YExtractor.parseVideoInfo(response.join().body());
			completableFuture.complete(new Response(null, videoInfo));
			
		} catch (Exception e) {
			completableFuture.complete(new Response(e.getMessage(), null));
		}
		return completableFuture;

	}
    
	/**
	 * @param searchText
	 * @param limit
	 * @return SearchListResponse return the searchListResponse sychronous
	 */
	public SearchListResponse search(String searchText,int limit) {
		try {
			HttpResponse<String> response = this.searchV3(searchText,limit);
			return new Gson().fromJson(response.body(),new TypeToken<SearchListResponse>(){}.getType());
		} catch (Exception e) {
		    System.out.println(e);
			return null;
		}
	}
    
	/**
	 * 
	 * @param searchText
	 * @param limit
	 * @return CompletableFuture<SearchListResponse> return the searchListResponse async
	 * @throws UnsupportedEncodingException
	 */
	public CompletableFuture<SearchListResponse> searchAsync(String searchText,int limit) throws UnsupportedEncodingException {
		CompletableFuture<SearchListResponse> completableFuture = new CompletableFuture<SearchListResponse>();
		try {

			  CompletableFuture<HttpResponse<String>> response = this.searchV3Async(searchText,limit);
			completableFuture.complete(new Gson().fromJson(response.join().body(),new TypeToken<SearchListResponse>(){}.getType()));
			
		} catch (Exception e) {
			completableFuture.complete(null);
		}

		return completableFuture;

	}
    
	/**
	 * 
	 * @param searchText
	 * @param channelId
	 * @param limit
	 * @return CompletableFuture<SearchListResponse> return the searchListResponse async
	 * @throws UnsupportedEncodingException
	 */
	public CompletableFuture<SearchListResponse> searchAsync(String searchText,String channelId,int limit) throws UnsupportedEncodingException {
		CompletableFuture<SearchListResponse> completableFuture = new CompletableFuture<SearchListResponse>();
		try {

			  CompletableFuture<HttpResponse<String>> response = this.searchV3Async(searchText,channelId,limit);
			completableFuture.complete(new Gson().fromJson(response.join().body(),new TypeToken<SearchListResponse>(){}.getType()));
			
		} catch (Exception e) {
			completableFuture.complete(null);
		}
		
		return completableFuture;

	}

}
