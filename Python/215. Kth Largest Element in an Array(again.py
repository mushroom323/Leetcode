class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        heapSize = len(nums)
        self.Heapify(nums, heapSize)
        for i in range(1, k):
            index = len(nums) - i
            nums[0] = nums[index]
            heapSize -= 1
            self.maxHeapify(nums, 0, heapSize)
        return nums[0]
    
    def Heapify(self, nums, heapSize):
        i = (int)(heapSize / 2)
        while i >= 0:
            self.maxHeapify(nums, i, heapSize)
            i -= 1

    def maxHeapify(self, nums, base, heapSize):
        largest = base
        left = 2 * base + 1
        right = 2 * base + 2
        if left < heapSize and nums[left] > nums[largest]:
            largest = left
        if right < heapSize and nums[right] > nums[largest]:
            largest = right
        if base != largest:
            nums[base], nums[largest] = nums[largest], nums[base]
            self.maxHeapify(nums, largest, heapSize)