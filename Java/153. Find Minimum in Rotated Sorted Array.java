package Java;

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;
        if (nums.length == 1) return nums[0];
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            else if (nums[mid] < nums[nums.length - 1]) r = mid - 1;
            else l = mid + 1;
        }
        return nums[0];
    }
}