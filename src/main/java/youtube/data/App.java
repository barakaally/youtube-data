package youtube.data;
import java.io.IOException;

import youtube.data.niche.Response;
import youtube.data.niche.SearchListResponse;
import youtube.data.yt.Youtube;
import youtube.data.yt.core.Client;


/**
 * youtube-data
 * created by baraka ally <baraka.ally.co.tz@gmail.com>
 */
class App
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
        /**
         * sample api-usage
         * apikey=required if you need to search on youtube
         * buildPlayer() is required for ciphered video,call it to avoid unauthorized response from youtube 
         */
        Youtube youtube=new Youtube("apiKey").buildPlayer();
        /**
         * seach video on youtube
         */
        SearchListResponse result= youtube.search("kwangaru", 2);
        String videoId=result.getItems().get(0).getId().getVideoId();
        /**
         * Get url to playVideo
         */
        Response response=youtube.getVideoInfo(videoId);
        String videoUrl=response.data.getPlayer_response().getStreamingData().getFormats().get(0).getUrl();

        System.out.println(videoUrl);
        
    }

}
