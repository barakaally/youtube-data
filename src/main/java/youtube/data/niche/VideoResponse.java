package youtube.data.niche;
/**
 * @description the VideoInfo Response
 */
public class VideoResponse {
    private Object errors;
    private VideoInfo data;
   

    /**
     * @return Object return the errors
     */
    public Object getErrors() {
        return errors;
    }

    /**
     * @return VideoInfo return the data
     */
    public VideoInfo getData() {
        return data;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(Object errors) {
        this.errors = errors;
    }

    /**
     * @param data the data to set
     */
    public void setData(VideoInfo data) {
        this.data = data;
    }

}
