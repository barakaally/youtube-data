package youtube.data.niche;

public class Statistic {
    private String viewCount;
    private String likeCount;
    private String dislikeCount;
    private String favoriteCount;
    private String commentCount;

    /**
     * @return String return the viewCount
     */
    public String getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount the viewCount to set
     */
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return String return the likeCount
     */
    public String getLikeCount() {
        return likeCount;
    }

    /**
     * @return String return the dislikeCount
     */
    public String getDislikeCount() {
        return dislikeCount;
    }

    /**
     * @return String return the favoriteCount
     */
    public String getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * @return String return the commentCount
     */
    public String getCommentCount() {
        return commentCount;
    }

}
