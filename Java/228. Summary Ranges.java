package Java;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> arr = new ArrayList<String>();
        if (nums.length == 0) return arr;
        int left = 0, right = 0;
        for (int i = 1; i < nums.length; i++) {
            if (((long)nums[i] - nums[right]) > 1) {
                if (left == right) {
                    arr.add(String.valueOf(nums[left]));
                } else {
                    arr.add(nums[left] + "->" + nums[right]);
                }
                left = i;
                right = i;
            } else {
                right = i;
            }
        }
        if (left == right) {
            arr.add(String.valueOf(nums[left]));
        } else {
            arr.add(nums[left] + "->" + nums[right]);
        }
        return arr;
    }
}