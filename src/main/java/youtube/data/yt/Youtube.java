package youtube.data.yt;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import youtube.data.yt.core.Client;
import youtube.data.Interface.IPlayerResponse;
import youtube.data.Interface.IVideoResponse;
import youtube.data.niche.SearchListResponse;
import youtube.data.niche.SearchResponse;
import youtube.data.niche.VideoResponse;
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

	public void buildPlayer(IPlayerResponse iplayer) {
		try
		{   
			Player.build();
			iplayer.onReady();		
			
		}
		catch(ArrayIndexOutOfBoundsException e){
			Player.build();
			iplayer.onReady();	
		}
		catch(Exception e)
		{
            iplayer.onFailure(e);
		}
	}
    
	/**
	 * 
	 * @param videoId
	 * @return Response return the response sychronous
	 */
	public VideoResponse getVideoInfo(String videoId){
		VideoResponse videoResponse=new VideoResponse();
		try{
			String response = this.fetchVideoInfo(videoId);
			videoResponse.setData(YExtractor.parseVideoInfo(response));
			return videoResponse;
		}
		 catch (Exception e) 
		{
			videoResponse.setErrors(e.getMessage());
			return videoResponse;
		}
	}

	/**
	 * 
	 * @param videoId
	 * @param result
	 * @return void
	 */
	public void getVideoInfo(String videoId,IVideoResponse result) {
		try {
			String response = this.fetchVideoInfo(videoId);
			result.onSuccess(YExtractor.parseVideoInfo(response));
			
		} catch (Exception e) {
		
			result.onFailure(e.getMessage());
		}
	}
    
	
    
	/**
	 * @param searchText
	 * @param limit
	 * @return SearchListResponse return the searchListResponse sychronous
	 */
	public SearchResponse search(String searchText,int limit) {
		SearchResponse searchResponse=new SearchResponse();
		try {
			String response = this.searchV3(searchText,limit);
			
			 searchResponse.setData(new Gson().fromJson(response,new TypeToken<SearchListResponse>(){}.getType()));
		
			return searchResponse;
		} catch (Exception e) {
		    searchResponse.setErrors(e.getMessage());
			return searchResponse;
		}
	}
    

}
