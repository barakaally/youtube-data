package youtube.data.niche;

public class SearchResult {
    private String kind;
    private String etag;
    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;
    private Video id;
    private Snippet snippet;

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public Video getId() {
        return id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

}
