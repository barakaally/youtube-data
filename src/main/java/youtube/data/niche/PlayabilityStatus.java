package youtube.data.niche;

public class PlayabilityStatus
{

    private String status;
    private Boolean playableInEmbed;
    private Object miniplayer;
    public String getStatus() {
        return status;
    }
    public Boolean getPlayableInEmbed() {
        return playableInEmbed;
    }
    
    public Object getMiniplayer() {
        return miniplayer;
    }
   
}