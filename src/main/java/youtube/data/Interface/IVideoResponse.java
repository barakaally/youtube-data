package youtube.data.Interface;

import youtube.data.niche.VideoInfo;

public interface IVideoResponse {
   void onSuccess(VideoInfo data);
   void onFailure(Object error);
}
