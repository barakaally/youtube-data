package youtube.data.niche;

public class Response {
public Object errors;
public VideoInfo data;
public Response(Object errors, VideoInfo data) {
    this.errors = errors;
    this.data = data;
}
}
