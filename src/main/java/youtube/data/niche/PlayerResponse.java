package youtube.data.niche;

import java.util.List;

public class PlayerResponse
    {
        private ResponseContext responseContext;
        private PlayabilityStatus playabilityStatus;
        private StreamingData streamingData;
        private Caption captions;
        private videoDetail videoDetails;
        private List<Object> annotations;
        private PlayerConfig playerConfig;
        private Storyboard storyboards;
        private Microformat microformat;
        private String trackingParams;
        private Attestation attestation;
        public  ResponseContext getResponseContext() {
            return responseContext;
        }
        
        public PlayabilityStatus getPlayabilityStatus() {
            return playabilityStatus;
        }
        
        public StreamingData getStreamingData() {
            return streamingData;
        }

        public Caption getCaptions() {
            return captions;
        }
       
        public videoDetail getVideoDetails() {
            return videoDetails;
        }

        public List<Object> getAnnotations() {
            return annotations;
        }
    
        public PlayerConfig getPlayerConfig() {
            return playerConfig;
        }
        public Storyboard getStoryboards() {
            return storyboards;
        }
        public Microformat getMicroformat() {
            return microformat;
        }
        public String getTrackingParams() {
            return trackingParams;
        }
        public Attestation getAttestation() {
            return attestation;
        }
    }