package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        // 合并区间
        List<int[]> arr = new ArrayList<int[]>();
        arr.add(points[0]);
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arr.getLast()[1] ) {
                if (points[i][1] < arr.getLast()[1]) {
                    arr.getLast()[1] = points[i][1];
                } 
            } else {
                arr.add(points[i]);
            }
        }
        return arr.size();
    }
}