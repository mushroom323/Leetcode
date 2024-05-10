class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        if len(nums) == 1:
            return nums[0]
        while l <= r:
            mid = (int)((l + r) / 2)
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            elif nums[mid] < nums[len(nums) - 1]:
                r = mid - 1
            else:
                l = mid + 1
        return nums[0]