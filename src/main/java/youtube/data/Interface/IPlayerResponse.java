package youtube.data.Interface;

public interface IPlayerResponse {
    void onReady();
    void onFailure(Exception error);
}
