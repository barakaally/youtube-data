package youtube.data._yt_player;
import java.util.List;
/**
 * the YtPlayer
 */
public class YtPlayer {
    private static String jsUrl;
    private static List<String> decipher;
    
    /**
     * 
     * @return  List<String>  return the decipher
     */
    public static List<String> getDecipher() {
        return decipher;
    }
    /**
     * 
     * @param decipher set decipher
     */
    public static void setDecipher(List<String> dec) {
        decipher = dec;
    }
   
    /**
     * 
     * @return String return the jsUrl
     */
    public static String getJsUrl() {
        return jsUrl;
    }

    /**
     * @param jsUrl the jsUrl to set
     */
    public static void setJsUrl(String url) {
        jsUrl = String.format("https://www.youtube.com%s", url);
    }

}
