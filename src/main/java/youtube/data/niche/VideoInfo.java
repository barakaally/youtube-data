package youtube.data.niche;

public class VideoInfo {
    private String vss_host;
    private String host_language;
    private String innertube_api_version;
    private String watermark;
    private String web_api_url;
    private PlayerResponse player_response;

    private String status;

    public String getVss_host() {
        return vss_host;
    }

    public String getHost_language() {
        return host_language;
    }

    public String getInnertube_api_version() {
        return innertube_api_version;
    }

    public String getWatermark() {
        return watermark;
    }

    public PlayerResponse getPlayer_response() {
        return player_response;
    }

    public String getWeb_api_url() {
        return web_api_url;
    }

    public String getStatus() {
        return status;
    }

}