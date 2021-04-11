package youtube.data.niche;
/**
 * @description the VideoInfo Response
 */
public class Response {
    private Object errors;
    private VideoInfo data;

    /**
     * 
     * @param errors
     * @param data
     */
    public Response(Object errors, VideoInfo data) {
        this.errors = errors;
        this.data = data;
    }

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

}
