package youtube.data.niche;
/**
 * @descrition the PlayabilityStatus
 */
public class PlayabilityStatus {

    private String status;
    private Boolean playableInEmbed;
    private Object miniplayer;

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return Boolean return the playableInEmbed
     */
    public Boolean isPlayableInEmbed() {
        return playableInEmbed;
    }

    /**
     * @return Object return the miniplayer
     */
    public Object getMiniplayer() {
        return miniplayer;
    }

}