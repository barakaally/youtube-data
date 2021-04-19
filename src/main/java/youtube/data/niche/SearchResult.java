package youtube.data.niche;
/**
 * @description the SearchResult
 */
public class SearchResult {
    private String kind;
    private String etag;
    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;
    private Video id;
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
     * @return Video return the id
     */
    public Video getId() {
        return id;
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
