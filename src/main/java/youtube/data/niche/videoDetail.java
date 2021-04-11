package youtube.data.niche;

import java.util.List;

public class videoDetail
{

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
    
    public String getVideoId() {
        return videoId;
    }
   
    public String getTitle() {
        return title;
    }
    
    public String getLengthSeconds() {
        return lengthSeconds;
    }
    
    public List<String> getKeywords() {
        return keywords;
    }
   
    public String getChannelId() {
        return channelId;
    }
    
    public Boolean getIsOwnerViewing() {
        return isOwnerViewing;
    }
   
    public String getShortDescription() {
        return shortDescription;
    }
    
    public Boolean getIsCrawlable() {
        return isCrawlable;
    }
    
    public Object getThumbnail() {
        return thumbnail;
    }
    
    public float getAverageRating() {
        return averageRating;
    }
    
    public Boolean getAllowRatings() {
        return allowRatings;
    }
    
    public String getViewCount() {
        return viewCount;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public Boolean getIsPrivate() {
        return isPrivate;
    }
    
    public Boolean getIsUnpluggedCorpus() {
        return isUnpluggedCorpus;
    }
    
    public Boolean getIsLiveContent() {
        return isLiveContent;
    }
   

}