class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        myset = []
        for i in range(len(s)):
            if s[i] not in myset:
                if s.count(s[i]) == 1:
                    return i
                else:
                    myset.append(s[i])
        return -1