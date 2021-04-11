package youtube.data.niche;

import java.util.List;
/**
 * @description the VideoDetail
 */
public class videoDetail {

    private String videoId;
    private String title;
    private String lengthSeconds;
    private List<String> keywords;
    private String channelId;
    private Boolean isOwnerViewing;
    private String shortDescription;
    private Boolean isCrawlable;
    private Object thumbnail;
    private float averageRating;
    private Boolean allowRatings;
    private String viewCount;
    private String author;
    private Boolean isPrivate;
    private Boolean isUnpluggedCorpus;
    private Boolean isLiveContent;

    /**
     * @return String return the videoId
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return String return the lengthSeconds
     */
    public String getLengthSeconds() {
        return lengthSeconds;
    }

    /**
     * @return List<String> return the keywords
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * @return String return the channelId
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * @return Boolean return the isOwnerViewing
     */
    public Boolean isIsOwnerViewing() {
        return isOwnerViewing;
    }

    /**
     * @return String return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @return Boolean return the isCrawlable
     */
    public Boolean isIsCrawlable() {
        return isCrawlable;
    }

    /**
     * @return Object return the thumbnail
     */
    public Object getThumbnail() {
        return thumbnail;
    }

    /**
     * @return float return the averageRating
     */
    public float getAverageRating() {
        return averageRating;
    }

    /**
     * @return Boolean return the allowRatings
     */
    public Boolean isAllowRatings() {
        return allowRatings;
    }

    /**
     * @return String return the viewCount
     */
    public String getViewCount() {
        return viewCount;
    }

    /**
     * @return String return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return Boolean return the isPrivate
     */
    public Boolean isIsPrivate() {
        return isPrivate;
    }

    /**
     * @return Boolean return the isUnpluggedCorpus
     */
    public Boolean isIsUnpluggedCorpus() {
        return isUnpluggedCorpus;
    }

    /**
     * @return Boolean return the isLiveContent
     */
    public Boolean isIsLiveContent() {
        return isLiveContent;
    }

}