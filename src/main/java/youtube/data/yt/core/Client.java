package youtube.data.yt.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import javax.net.ssl.HttpsURLConnection;

import youtube.data.Interface.HttpResponse;

/**
 * @description the Client
 */
public abstract class Client {
	private String apiKey;

	/**
	 * @descrition Client's constructor
	 */
	public Client() {
	}

	/**
	 * @param key
	 * @description Client's constructor
	 */
	public Client(String key) {
		this.apiKey = key;
	}

	/**
	 * 
	 * @param videoId
	 * @return CompletableFuture<HttpResponse<String>> return the String of
	 *         videoInfo async
	 */
	protected CompletableFuture<String> fetchVideoInfoAsync(String videoId) {
		CompletableFuture<String> completable = new CompletableFuture<String>();
		HttpsURLConnection mConnection;
		try {
			String url=String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId);
			mConnection = (HttpsURLConnection) new URL(url).openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);
			reader.close();
			completable.complete(builder.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return completable;
	}

	/**
	 * @param videoId
	 * @return HttpResponse<String> return the String of videoInfo syschrous
	 * @throws IOException
	 * @throws InterruptedException
	 */
	protected String fetchVideoInfo(String videoId) throws IOException, InterruptedException {
        String url=String.format("https://www.youtube.com/get_video_info?video_id=%s&el=embedded&ps=default&eurl=&gl=US&hl=en",videoId);
		HttpsURLConnection mConnection = (HttpsURLConnection) new URL(url).openConnection();
		mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

		BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null)
			builder.append(line);

		reader.close();

		return builder.toString();
	}

	/**
	 * 
	 * @return CompletableFuture<HttpResponse<String>> return the String of playerJs
	 *         async
	 */
	protected static CompletableFuture<HttpResponse> getPlayerJsAsync() {
		CompletableFuture<HttpResponse> completable = new CompletableFuture<HttpResponse>();
		HttpResponse httResponse = new HttpResponse();
		try {
			HttpsURLConnection mConnection = (HttpsURLConnection) new URL("https://www.youtube.com/").openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();
			httResponse.setBody(builder.toString());
			completable.complete(httResponse);
		} catch (Exception e) {
			httResponse.setError(e);
			completable.complete(httResponse);
		}

		return completable;
	}

	/**
	 * 
	 * @return HttpResponse<String> return the String of Youtube playerJs sychronous
	 * @throws IOException
	 * @throws InterruptedException
	 */
	protected static String getPlayerJs() throws IOException, InterruptedException {
		HttpsURLConnection mConnection = (HttpsURLConnection) new URL("https://www.youtube.com/").openConnection();
		mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

		BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null)
			builder.append(line);

		reader.close();
		return builder.toString();
	}

	/**
	 * @param jsUrl
	 * @return CompletableFuture<HttpResponse<String>> return the String of Youtube
	 *         playerDecipher async
	 */
	protected static CompletableFuture<String> getYtPlayerDecipherAsync(String jsUrl) {
		CompletableFuture<String> completable = new CompletableFuture<String>();
		try {
			HttpsURLConnection mConnection = (HttpsURLConnection) new URL(jsUrl).openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();
			completable.complete(builder.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return completable;
	}

	/**
	 * @param jsUrl
	 * @return String return the String of Youtube playerDecipher sychrounous
	 * @throws Exception
	 */
	protected static String getYtPlayerDecipher(String jsUrl) throws Exception {

		try {
			HttpsURLConnection mConnection = (HttpsURLConnection) new URL(jsUrl).openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();
			return builder.toString();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * 
	 * @param searchText
	 * @param channelId
	 * @param limit
	 * @return HttpResponse<String> return the String of searchListResult
	 * @throws Exception
	 */
	protected String searchV3(String searchText, String channelId, int limit) throws Exception {
		if (apiKey != null) {
			
			String url=String.format("https://www.googleapis.com/youtube/v3/search?key=%s&channelId=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,channelId,limit,searchText.replaceAll("\\s","%20"));
			HttpsURLConnection mConnection = (HttpsURLConnection) new URL(url).openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();

			return builder.toString();

		} else {
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
	protected CompletableFuture<String> searchV3Async(String searchText, String channelId, int limit) throws Exception {
		CompletableFuture<String> completable = new CompletableFuture<String>();
		if (apiKey != null) {
            String url=String.format("https://www.googleapis.com/youtube/v3/search?key=%s&channelId=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,channelId,limit,searchText.replaceAll("\\s","%20"));
			HttpsURLConnection mConnection = (HttpsURLConnection) new URL(url).openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();

			completable.complete(builder.toString());
		} else {
			throw new Exception("Api Key not provided");
		}

		return completable;
	}

	/**
	 * 
	 * @param searchText
	 * @param limit
	 * @return HttpResponse<String> return the String of searchListResult sychronous
	 * @throws Exception
	 */
	protected String searchV3(String searchText, int limit) throws Exception {

		if (apiKey != null) {
			String url=String.format("https://www.googleapis.com/youtube/v3/search?key=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,limit,searchText.replaceAll("\\s","%20"));
			HttpsURLConnection mConnection = (HttpsURLConnection) new URL(url).openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();

			return builder.toString();
		} else {
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
	protected CompletableFuture<String> searchV3Async(String searchText, int limit) throws Exception {
		CompletableFuture<String> completable = new CompletableFuture<String>();
		if (apiKey != null) {
			String url=String.format("https://www.googleapis.com/youtube/v3/search?key=%s&part=snippet,id&order=date&maxResults=%d&q=%s",apiKey,limit,searchText.replaceAll("\\s","%20"));
			HttpsURLConnection mConnection = (HttpsURLConnection) new URL(url).openConnection();
			mConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();

			completable.complete(reader.toString());
		} else {
			throw new Exception("Api Key not provided");
		}

		return completable;
	}
}
