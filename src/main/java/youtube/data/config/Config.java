package youtube.data.config;


import youtube.data._yt_player.YtPlayer;

public class Config {

    private static YtPlayer player;

    public static YtPlayer getPlayer() {
        return player;
    }

    public static void setPlayer(YtPlayer yplayer) {
        player = yplayer;
    }
}
