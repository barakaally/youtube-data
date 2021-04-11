package youtube.data.yt.core;

import java.net.http.HttpResponse;
import youtube.data._yt_player.YtPlayer;
import youtube.data.config.YtConfig;
import youtube.data.yt.util.YExtractor;

public class Player {

    public static void build() {

        try {
            HttpResponse<String> response = Client.getPlayerJs();
            YtPlayer player = YExtractor.parsePlayerInfo(response.body());
            Player.set(player);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void set(YtPlayer player) {
        try {

            player.setDecipher(Decipher.load(player));
            YtConfig.setPlayer(player);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public static YtPlayer get(){
        return YtConfig.getPlayer();
    }

}
