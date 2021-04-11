package youtube.data.niche;
/**
 * @description the Snippet
 */
public class Snippet {
    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private Thumbnail thumbnails;

    /**
     * @return String return the publishedAt
     */
    public String getPublishedAt() {
        return publishedAt;
    }

    /**
     * @return String return the channelId
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    public Thumbnail getThumbnails() {
        return thumbnails;
    }

}
