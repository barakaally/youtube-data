package youtube.data.yt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import youtube.data.yt.core.Client;
import youtube.data.niche.Response;
import youtube.data.niche.VideoInfo;
import youtube.data.yt.util.Player;
import youtube.data.yt.util.YExtractor;


public class Youtube {

	public Youtube() {
	}

	public Youtube(String apiKey) {
	}

	public Youtube buildPlayer() {
		Player.build();
		return this;
	}

	public Response getVideoInfo(String videoId) throws IOException, InterruptedException {
		try {
			HttpResponse<String> response = Client.getVideoInfo(videoId);
			return new Response(null, YExtractor.parseVideoInfo(response.body()));
		} catch (Exception e) {
			return new Response(e.getMessage(), null);
		}
	}

	public CompletableFuture<Response> getVideoInfoAsync(String videoId) throws UnsupportedEncodingException {
		CompletableFuture<Response> completableFuture = new CompletableFuture<Response>();
		try {

			CompletableFuture<HttpResponse<String>> response = Client.getVideoInfoAsync(videoId);
			VideoInfo videoInfo = YExtractor.parseVideoInfo(response.join().body());
			completableFuture.complete(new Response(null, videoInfo));
			
		} catch (Exception e) {
			completableFuture.complete(new Response(e.getMessage(), null));
		}
		return completableFuture;

	}

}
