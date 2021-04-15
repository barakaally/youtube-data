package youtube.data.yt.core;

import java.util.List;


import youtube.data.yt.util.YExtractor;
/**
 * @description the Player
 */
public class Player {

    private  List<String> decipher;
    private  String jsUrl;

    public Player(String jsUrl,List<String> decipher) {
        this.decipher = decipher;
        this.jsUrl = jsUrl;
    }

    /**
     * 
     * @description build and set Youtube Player
     */
    public static void build() {

        try 
        {
            String response = Client.getPlayerJs();
            YExtractor.parsePlayer(response);  
           
        } 
        catch (Exception e) {

            e.printStackTrace();
        }

    } 

    /**
     * @return List<String> return the decipher
     */
    public List<String> getDecipher() {
        return decipher;
    }

    /**
     * @return String return the jsUrl
     */
    public String getJsUrl() {
        return jsUrl;
    }

    

}
