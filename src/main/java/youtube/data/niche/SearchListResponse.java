package youtube.data.niche;

import java.util.List;
/**
 * @description the SearchListResponse
 */
public class SearchListResponse {
  private String kind;
  private String etag;
  private String nextPageToken;
  private String regionCode;
  private PageInfo pageInfo;
  private List<SearchResult> items;

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
   * @return String return the nextPageToken
   */
  public String getNextPageToken() {
    return nextPageToken;
  }

  /**
   * @return String return the regionCode
   */
  public String getRegionCode() {
    return regionCode;
  }

  /**
   * @return PageInfo return the pageInfo
   */
  public PageInfo getPageInfo() {
    return pageInfo;
  }

  /**
   * @return List<SearchResult> return the items
   */
  public List<SearchResult> getItems() {
    return items;
  }

}
