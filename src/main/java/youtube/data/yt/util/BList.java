package youtube.data.yt.util;

import java.util.List;

public class BList {
    public static <T extends Object> List<T> splice(List<T> items, int startIndex, int endIndex) {
        for (int a = startIndex; a < endIndex; a++) {
            items.remove(startIndex);
        }

        return items;
    }

    public static String[] swap(String[] items, int startIndex, int endIndex) {
        String[] q =items;
        String a = items[startIndex];
        String z = items[endIndex];
        q[startIndex] = z;
        q[endIndex] = a;
        return q;
    }
}
