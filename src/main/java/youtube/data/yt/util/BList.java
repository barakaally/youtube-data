package youtube.data.yt.util;

import java.util.List;
/**
 * @description the Blist
 */
public class BList {
    /**
     * 
     * @param <T>
     * @param items
     * @param startIndex
     * @param endIndex
     * @return List<T> return the List<T> of sliced list
     */
    public static <T extends Object> List<T> splice(List<T> items, int startIndex, int endIndex) {
        for (int a = startIndex; a < endIndex; a++) {
            items.remove(startIndex);
        }

        return items;
    }

    /**
     * 
     * @param items
     * @param startIndex
     * @param endIndex
     * @return String[] return the String[] of swapped array
     */
    public static String[] swap(String[] items, int startIndex, int endIndex) {
        String[] q =items;
        String a = items[startIndex];
        String z = items[endIndex];
        q[startIndex] = z;
        q[endIndex] = a;
        return q;
    }
}
