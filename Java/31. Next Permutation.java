package Java;

import java.util.Arrays;

class Solution {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void nextPermutation(int[] nums) {
        boolean isSwap = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (!isSwap && (nums[i - 1] < nums[i])) {
                int minPos = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] < nums[minPos]) minPos = j;
                }
                swap(nums, i - 1, minPos);
                isSwap = true;
                System.out.println(i);
                Arrays.sort(nums, i, nums.length);
                break;
            } 
        }
        if (!isSwap) {
            Arrays.sort(nums);
        }
    }
}

/*
 * 1234
 * 2134
 * 3124
 * 3214   43521 45123
 * 43512 43521 45123
 * 42351 
 * 43125 43152
 */