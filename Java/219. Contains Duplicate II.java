package Java;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> myset = new HashSet<Integer>();
        int l = 0, r = k;
        for (int i = l; i <= r && i < nums.length; i++) {
            if (!myset.contains(nums[i])) {
                myset.add(nums[i]);
            } else return true;
        }
        while (true) {
            myset.remove(nums[l]);
            l++;
            r++;
            if (r >= nums.length) break;
            if (!myset.contains(nums[r])) {
                myset.add(nums[r]);
            } else return true;
        }
        return false;
    }
}