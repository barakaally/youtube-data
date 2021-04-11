package youtube.data.niche;

import java.util.List;

public class StreamingData
{
    private String expiresInSeconds;
    private List<Format> formats;
    private List<Format> adaptiveFormats;

    public String getExpiresInSeconds() {
        return expiresInSeconds;
    }
   
    public List<Format> getFormats() {
        return formats;
    }
   
    public List<Format> getAdaptiveFormats() {
        return adaptiveFormats;
    }
   

}