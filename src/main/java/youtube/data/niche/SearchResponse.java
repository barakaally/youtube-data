package youtube.data.niche;

public class SearchResponse {
    private Object errors;
    private SearchListResponse data;
    

    /**
     * @return Object return the errors
     */
    public Object getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(Object errors) {
        this.errors = errors;
    }

    /**
     * @return SearchListResponse return the data
     */
    public SearchListResponse getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(SearchListResponse data) {
        this.data = data;
    }

}
