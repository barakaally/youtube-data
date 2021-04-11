package youtube.data.niche;

import java.util.List;
/**
 * @description the StreamingData
 */
public class StreamingData {
    private String expiresInSeconds;
    private List<Format> formats;
    private List<Format> adaptiveFormats;

    /**
     * @return String return the expiresInSeconds
     */
    public String getExpiresInSeconds() {
        return expiresInSeconds;
    }

    /**
     * @return List<Format> return the formats
     */
    public List<Format> getFormats() {
        return formats;
    }

    /**
     * @return List<Format> return the adaptiveFormats
     */
    public List<Format> getAdaptiveFormats() {
        return adaptiveFormats;
    }

}