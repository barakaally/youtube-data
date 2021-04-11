package youtube.data._yt_player;
import java.util.ArrayList;
import java.util.List;

public class YtPlayer {
    private String host;
    private String jsUrl;
    private List<String> decipher;

    public YtPlayer(String host, String jsUrl) {
        this.host = host;
        this.jsUrl = String.format("https://www.youtube.com%s", jsUrl);
        this.decipher=new ArrayList<String>();
    }

    public List<String> getDecipher() {
        return decipher;
    }

    public void setDecipher(List<String> decipher) {
        this.decipher = decipher;
    }

    public String getHost() {
        return host;
    }

    public String getJsUrl() {
        return jsUrl;
    }


}
