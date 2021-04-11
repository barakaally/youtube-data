package youtube.data.niche;
/**
 * @description the Playerresponse
 */
public class PlayerResponse {
    private PlayabilityStatus playabilityStatus;
    private StreamingData streamingData;
    private videoDetail videoDetails;
    private PlayerConfig playerConfig;
    private Microformat microformat;

    /**
     * @return PlayabilityStatus return the playabilityStatus
     */
    public PlayabilityStatus getPlayabilityStatus() {
        return playabilityStatus;
    }

    /**
     * @return StreamingData return the streamingData
     */
    public StreamingData getStreamingData() {
        return streamingData;
    }

    /**
     * @return videoDetail return the videoDetails
     */
    public videoDetail getVideoDetails() {
        return videoDetails;
    }

    /**
     * @return PlayerConfig return the playerConfig
     */
    public PlayerConfig getPlayerConfig() {
        return playerConfig;
    }

    /**
     * @return Microformat return the microformat
     */
    public Microformat getMicroformat() {
        return microformat;
    }

}