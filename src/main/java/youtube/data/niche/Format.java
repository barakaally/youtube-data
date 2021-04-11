
package youtube.data.niche;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import youtube.data.yt.util.YExtractor;



public class Format
    {
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
       
       public String getUrl() {
            if(url!=null){
             return url;
            }
            else
            {
                try {
                    return YExtractor.parseSignatureCipher(URLDecoder.decode(signatureCipher,"UTF-8"));

                } catch (UnsupportedEncodingException e) {
                    
                    return null;
                }
            }
        }
        
        public String getItag() {
            return itag;
        }
    
        public String getMimeType() {
            return mimeType;
        }

        public int getBitrate() {
            return bitrate;
        }
        public int getWidth() {
            return width;
        }
        
        public int getHeight() {
            return height;
        }
        public String getLastModified() {
            return lastModified;
        }
        public String getContentLength() {
            return contentLength;
        }
        
        public String getQuality() {
            return quality;
        }
        
        public int getFps() {
            return fps;
        }
        
        public String getQualityLabel() {
            return qualityLabel;
        }
        
        public String getProjectionType() {
            return projectionType;
        }
       
        public int getAverageBitrate() {
            return averageBitrate;
        }
        
        public String getAudioQuality() {
            return audioQuality;
        }
        
        public String getApproxDurationMs() {
            return approxDurationMs;
        }
        
        public String getAudioSampleRate() {
            return audioSampleRate;
        }
        
        public int getAudioChannels() {
            return audioChannels;
        }
        
   
    }
