package youtube.data.yt.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import youtube.data._yt_player.YtPlayer;
import youtube.data.yt.util.BList;
import youtube.data.yt.util.YExtractor;
/**
 * @description the Decipher
 */
public class Decipher {
    /**
     * 
     * @param a  rotating input array
     * @param s  decipher's function 
     * @return String[] return the String[] of rotated array
     */
    private static String[] decreptSignatuture(String[] a, String s) {
        int b = Integer.parseInt(s.replaceAll("[a-zA-Z0-9]{1,}\\([a-zA-Z0-9]{1,}\\,", "").replaceAll("\\)", "").trim());

        return s.contains("Bx")?slice(a, b):s.contains("By")?shift(a, b):s.contains("Bz")?reverse(a, b):a;
    }
    /**
     * 
     * @param sig signature
     * @return String return the String of deciphered signature
     */
    public static String decode(String sig) {

        String[] a = sig.split("");
        for (String d : YtPlayer.getDecipher()) {
            a = decreptSignatuture(a, d);
        }

        return String.join("", a);
    }
    /**
     * 
     * @param player
     * @return List<String> return the List<String> of decipher fn of loaded player
     */
    public static List<String> load(String jsUrl) {

        try {
            String response = Client.getYtPlayerDecipher(jsUrl);
            return YExtractor.parsePlayerDecipher(response);

        } catch (Exception e) {

            System.out.println("failed to load decipher fn");
        }

        return new ArrayList<String>();

    }

    private static String[] slice(String[] a, int b) {
        List<String> list = new LinkedList<String>(Arrays.asList(a));
        return BList.splice(list, 0, b).toArray(new String[list.size()]);
    }

    private static String[] shift(String[] a, int b) {
        String c = a[0];
        a[0] = a[b % a.length];
        a[b % a.length] = c;

        return a;
    }

    private static String[] reverse(String[] a, int b) {
        List<String> list = Arrays.asList(a);
        Collections.reverse(list);
        return list.toArray(new String[list.size()]);
    }

}