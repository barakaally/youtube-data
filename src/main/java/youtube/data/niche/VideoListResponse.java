package youtube.data.niche;

import java.util.List;

public class VideoListResponse {
    private String kind;
    private String etag;
    private PageInfo pageInfo;
    private List<VideoResult> items;
    


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
     * @return PageInfo return the pageInfo
     */
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    /**
     * @return List<VideoResult> return the items
     */
    public List<VideoResult> getItems() {
        return items;
    }

}
