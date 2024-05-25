class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        myset = set()
        l = 0
        r = k
        for i in range(min(len(k + 1), len(nums))):
            if nums[i] in myset:
                return True
            else:
                myset.add(nums[i])
        while True:
            myset.remove(nums[l])
            l += 1
            r += 1
            if r > len(nums):
                break
            if nums[r] in myset:
                return True
            else:
                myset.add(nums[r])
        return False
