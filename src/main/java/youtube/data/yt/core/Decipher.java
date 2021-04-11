package youtube.data.yt.core;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import youtube.data._yt_player.YtPlayer;
import youtube.data.yt.util.BList;
import youtube.data.yt.util.YExtractor;

public class Decipher {

    private static String[] decreptSignatuture(String[] a, String s) {
        int b = Integer.parseInt(s.replaceAll("[a-zA-Z0-9]{1,}\\([a-zA-Z0-9]{1,}\\,", "").replaceAll("\\)", "").trim());

        return s.contains("Bx")?slice(a, b):s.contains("By")?shift(a, b):s.contains("Bz")?reverse(a, b):a;
    }

    public static String decode(String sig) {
        YtPlayer player = Player.get();
        String[] a = sig.split("");
        for (String d : player.getDecipher()) {
            a = decreptSignatuture(a, d);
        }
        return String.join("", a);
    }

    public static List<String> load(YtPlayer player) {

        try {
            HttpResponse<String> response = Client.getYtPlayerDecipher(player.getJsUrl());
            return YExtractor.parsePlayerDecipher(response.body());

        } catch (Exception e) {

            System.out.println(e.getMessage());
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