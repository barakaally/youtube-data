package youtube.data.niche;

import java.util.List;

public class VideoResult {
    private String kind;
    private String etag;
    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;
    private String id;
    private List<String> tags;
    private Snippet snippet;
    private Statistic statistics;
    

    /**
     * @return String return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @return String return the etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * @return String return the channelTitle
     */
    public String getChannelTitle() {
        return channelTitle;
    }


    /**
     * @return String return the liveBroadcastContent
     */
    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    /**
     * @return String return the publishTime
     */
    public String getPublishTime() {
        return publishTime;
    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return List<String> return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * @return Snippet return the snippet
     */
    public Snippet getSnippet() {
        return snippet;
    }

    /**
     * @return Statistic return the statistics
     */
    public Statistic getStatistics() {
        return statistics;
    }

}
