package youtube.data.niche;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import youtube.data.yt.util.YExtractor;
/**
 * @description the video format
 */
public class Format {
    private String itag;
    private String signatureCipher;
    private String url;
    private String mimeType;
    private int bitrate;
    private int width;
    private int height;
    private String lastModified;
    private String contentLength;
    private String quality;
    private int fps;
    private String qualityLabel;
    private String projectionType;
    private int averageBitrate;
    private String audioQuality;
    private String approxDurationMs;
    private String audioSampleRate;
    private int audioChannels;

    /**
     * @return String return the url
     */
    public String getUrl() {
        if (url != null) {
            return url;
        } else {
            try {
                return YExtractor.parseSignatureCipher(URLDecoder.decode(signatureCipher, "UTF-8"));

            } catch (UnsupportedEncodingException e) {

                return null;
            }
        }
    }

    /**
     * @return String return the itag
     */
    public String getItag() {
        return itag;
    }

    /**
     * @return String return the mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @return int return the bitrate
     */
    public int getBitrate() {
        return bitrate;
    }

    /**
     * @return int return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return int return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return String return the lastModified
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     * @return String return the contentLength
     */
    public String getContentLength() {
        return contentLength;
    }

    /**
     * @return String return the quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * @return int return the fps
     */
    public int getFps() {
        return fps;
    }

    /**
     * @return String return the qualityLabel
     */
    public String getQualityLabel() {
        return qualityLabel;
    }

    /**
     * @return String return the projectionType
     */
    public String getProjectionType() {
        return projectionType;
    }

    /**
     * @return int return the averageBitrate
     */
    public int getAverageBitrate() {
        return averageBitrate;
    }

    /**
     * @return String return the audioQuality
     */
    public String getAudioQuality() {
        return audioQuality;
    }

    /**
     * @return String return the approxDurationMs
     */
    public String getApproxDurationMs() {
        return approxDurationMs;
    }

    /**
     * @return String return the audioSampleRate
     */
    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * @return int return the audioChannels
     */
    public int getAudioChannels() {
        return audioChannels;
    }

}
