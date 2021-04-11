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

	public Youtube(String apiKey) {
		super(apiKey);
	}

	public Youtube buildPlayer() {
		Player.build();
		return this;
	}
    
	
	public Response getVideoInfo(String videoId) throws IOException, InterruptedException {
		try {
			HttpResponse<String> response = this.fetchVideoInfo(videoId);
			return new Response(null, YExtractor.parseVideoInfo(response.body()));
		} catch (Exception e) {
			return new Response(e.getMessage(), null);
		}
	}

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

	public SearchListResponse search(String text,int limit) {
		try {
			HttpResponse<String> response = this.searchV3(text,limit);
			return new Gson().fromJson(response.body(),new TypeToken<SearchListResponse>(){}.getType());
		} catch (Exception e) {
		    System.out.println(e);
			return null;
		}
	}

	public CompletableFuture<SearchListResponse> searchAsync(String text,int limit) throws UnsupportedEncodingException {
		CompletableFuture<SearchListResponse> completableFuture = new CompletableFuture<SearchListResponse>();
		try {

			  CompletableFuture<HttpResponse<String>> response = this.searchV3Async(text,limit);
			completableFuture.complete(new Gson().fromJson(response.join().body(),new TypeToken<SearchListResponse>(){}.getType()));
			
		} catch (Exception e) {
			completableFuture.complete(null);
		}

		return completableFuture;

	}

	public CompletableFuture<SearchListResponse> searchAsync(String text,String channelId,int limit) throws UnsupportedEncodingException {
		CompletableFuture<SearchListResponse> completableFuture = new CompletableFuture<SearchListResponse>();
		try {

			  CompletableFuture<HttpResponse<String>> response = this.searchV3Async(text,channelId,limit);
			completableFuture.complete(new Gson().fromJson(response.join().body(),new TypeToken<SearchListResponse>(){}.getType()));
			
		} catch (Exception e) {
			completableFuture.complete(null);
		}
		
		return completableFuture;

	}

}
