package Java;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = (l + r) / 2;
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        // 找旋转下标k nums[k] > nums[k + 1]
        while (l <= r) {
            mid = (l + r) / 2;
            //System.out.println(mid);
            if (nums[mid] > nums[mid + 1]) break;
            else if (nums[nums.length - 1] > nums[mid]) r = mid - 1;
            else l = mid + 1;
        }
        l = 0;
        r = nums.length - 1;
        if (target < nums[0]) l = mid + 1;
        else if (target <= nums[mid]) r = mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}