package youtube.data.niche;
/**
 * @description the Snippet
 */
public class Snippet {
    private String publishedAt;
    private String channelId;
    private String channelTitle;
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


    /**
     * @param publishedAt the publishedAt to set
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * @param channelId the channelId to set
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * @return String return the channelTitle
     */
    public String getChannelTitle() {
        return channelTitle;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param thumbnails the thumbnails to set
     */
    public void setThumbnails(Thumbnail thumbnails) {
        this.thumbnails = thumbnails;
    }

}
