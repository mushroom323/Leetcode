"""
关键点在于要优先移除在位置在i的数字，位置i满足num[i] > num[i + 1]
 */
"""
class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if k >= len(num):
            return "0"
        deque = []
        count = 0
        for i in range(len(num)):
            if i > 0 and num[i] < num[i - 1]:
                while len(deque) > 0 and deque[len(deque) - 1] > num[i] and count < k:
                    deque.pop()
                    count += 1
            deque.append(num[i])
        ans = ""
        while count < k:
            deque.pop()
            count += 1
        while len(deque) > 0:
            if deque[0] == "0" and ans == "":
                deque.pop(0)
            else:
                ans += deque.pop(0)
        if ans == "":
            ans = "0"
        return ans