package youtube.data.yt.core;

import youtube.data.yt.util.YExtractor;
/**
 * @description the Player
 */
public class Player {
    /**
     * @description build and set Youtube Player
     */
    public static void build() {

        try {
            String response = Client.getPlayerJs();
            YExtractor.parsePlayer(response);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }


}
