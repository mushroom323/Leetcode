class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        mid = (int)((l + r) / 2)
        if len(nums) == 1 and nums[0] == target:
            return 0
        elif len(nums) == 1:
            return -1
        while l <= r:
            mid = (int)((l + r) / 2)
            if nums[mid] > nums[mid + 1]:
                break
            elif nums[mid] < nums[len(nums) - 1]:
                r = mid - 1
            else:
                l = mid + 1
        l = 0
        r = len(nums) - 1
        if target < nums[0]:
            l = mid + 1
        elif target <= nums[mid]:
            r = mid
        while l <= r:
            mid = (int)((l + r) / 2)
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return -1
        