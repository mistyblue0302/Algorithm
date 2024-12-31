import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] findOceanViewBuildings(int[] heights) {
        int max = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = heights.length - 1; i >= 0; i++) {
            if (heights[i] > max) {
                list.add(i);
                max = heights[i];
            }
        }

        int[] result = new int[list.size()];
        Collections.reverse(list);
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
