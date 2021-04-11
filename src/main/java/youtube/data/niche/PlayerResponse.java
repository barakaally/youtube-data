package youtube.data.niche;

public class PlayerResponse {
    private PlayabilityStatus playabilityStatus;
    private StreamingData streamingData;
    private videoDetail videoDetails;
    private PlayerConfig playerConfig;
    private Microformat microformat;

    public PlayabilityStatus getPlayabilityStatus() {
        return playabilityStatus;
    }

    public StreamingData getStreamingData() {
        return streamingData;
    }

    public videoDetail getVideoDetails() {
        return videoDetails;
    }

    public PlayerConfig getPlayerConfig() {
        return playerConfig;
    }

    public Microformat getMicroformat() {
        return microformat;
    }

}