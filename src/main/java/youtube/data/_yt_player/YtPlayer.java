package youtube.data._yt_player;
import java.util.ArrayList;
import java.util.List;
/**
 * the YtPlayer
 */
public class YtPlayer {
    private String host;
    private String jsUrl;
    private List<String> decipher;
    /**
     * 
     * @param host
     * @param jsUrl
     */
    public YtPlayer(String host, String jsUrl) {
        this.host = host;
        this.jsUrl = String.format("https://www.youtube.com%s", jsUrl);
        this.decipher=new ArrayList<String>();
    }
    /**
     * 
     * @return  List<String>  return the decipher
     */
    public List<String> getDecipher() {
        return decipher;
    }
    /**
     * 
     * @param decipher set decipher
     */
    public void setDecipher(List<String> decipher) {
        this.decipher = decipher;
    }
    /**
     * 
     * @return  String return the host
     */
    public String getHost() {
        return host;
    }
    /**
     * 
     * @return String return the jsUrl
     */
    public String getJsUrl() {
        return jsUrl;
    }


}
