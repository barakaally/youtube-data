package youtube.data;
import java.io.IOException;

import youtube.data.niche.Response;
import youtube.data.yt.Youtube;


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
         */
        Youtube youtube=new Youtube().buildPlayer();
        Response response=youtube.getVideoInfo("ULJxwUkSEPs");
        System.out.println(String.valueOf(response.data.getPlayer_response().getStreamingData().getFormats().get(0).getUrl().toString()));
          
    }
}
