'''
new knowledge:
py的切片是制造一个新的数组，但是可以直接对其进行部分赋值。
sorted的是返回new list，而sort是原地排序。
'''
class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 1
        isSwap = False
        while i > 0:
            if nums[i] > nums[i - 1]:
                isSwap = True
                break
            else:
                i -= 1
        
        if isSwap:
            i -= 1
            minPos = i + 1
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i] and nums[j] < nums[minPos]:
                    minPos = j
            nums[i], nums[minPos] = nums[minPos], nums[i]
            tmp = nums[(i + 1)::]
            tmp.sort()
            nums[(i + 1)::] = tmp
        else:
            nums.sort()