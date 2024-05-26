package Java;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<int[]>();
        int left = -1, right = -1, i = 0;
        boolean isin = false;
        for (; i < intervals.length; i++) {
            if (left == -1) {
                if (intervals[i][0] >= newInterval[0]) {
                    isin = true;
                } else if (intervals[i][1] >= newInterval[0]) {
                    newInterval[0] = intervals[i][0];
                    isin = true;
                }
            } 
            if (right == -1) {
                if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]) {
                    newInterval[1] = intervals[i][1];
                    arr.add(newInterval);
                    i++;
                    right = 1;
                    break;
                } else if (newInterval[1] < intervals[i][0]) {
                    arr.add(newInterval);
                    right = 1;
                    break;
                }
            }
            if (!isin) arr.add(intervals[i]);
        }
        if (right == -1) {
            arr.add(newInterval);
        } else {
            for (;i < intervals.length; i++) {
                arr.add(intervals[i]);
            }
        }
        int[][] ans = arr.toArray(new int[arr.size()][2]);
        return ans;
    }
}