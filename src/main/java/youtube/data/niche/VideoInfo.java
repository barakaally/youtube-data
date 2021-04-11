package youtube.data.niche;
/**
 * @description the VideoInfo
 */
public class VideoInfo {
    private String vss_host;
    private String host_language;
    private String innertube_api_version;
    private String watermark;
    private String web_api_url;
    private PlayerResponse player_response;
    private String status;

    /**
     * @return String return the vss_host
     */
    public String getVss_host() {
        return vss_host;
    }

    /**
     * @return String return the host_language
     */
    public String getHost_language() {
        return host_language;
    }

    /**
     * @return String return the innertube_api_version
     */
    public String getInnertube_api_version() {
        return innertube_api_version;
    }

    /**
     * @return String return the watermark
     */
    public String getWatermark() {
        return watermark;
    }

    /**
     * @return String return the web_api_url
     */
    public String getWeb_api_url() {
        return web_api_url;
    }

    /**
     * @return PlayerResponse return the player_response
     */
    public PlayerResponse getPlayer_response() {
        return player_response;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

}