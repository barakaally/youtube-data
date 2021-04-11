package youtube.data;
import java.io.IOException;

import youtube.data.niche.Response;
import youtube.data.niche.SearchListResponse;
import youtube.data.yt.Youtube;

/**
 * youtube-data
 * created by baraka ally <baraka.ally.co.tz@gmail.com>
 * #use this for testing only#
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
        Youtube youtube=new Youtube("your apiKey").buildPlayer();
        /**
         * seach video on youtube
         */
        SearchListResponse result= youtube.search("kwangaru", 2);
        String videoId=result.getItems().get(0).getId().getVideoId();
        /**
         * Get url to playVideo
         */
        Response response=youtube.getVideoInfo(videoId);
        String videoUrl=response.getData().getPlayer_response().getStreamingData().getFormats().get(0).getUrl();

        System.out.println(videoUrl);
        
    }

}
