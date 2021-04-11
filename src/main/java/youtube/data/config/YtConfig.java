package youtube.data.config;


import youtube.data._yt_player.YtPlayer;
/**
 * the YtConfig
 */
public abstract class YtConfig {

    private static YtPlayer player;
    /**
     * 
     * @return YtPlayer return the player
     */
    public static YtPlayer getPlayer() {
        return player;
    }
    /**
     * 
     * @param yplayer set the player
     */
    public static void setPlayer(YtPlayer yplayer) {
        player = yplayer;
    }
}
